package com.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.fileOperation.CreateUserInputFiles;
import com.movie.fileOperation.FileSaveToList;
import com.movie.fileOperation.HDFSFileOperation;
import com.movie.hadoop.StartupRecommend;
import com.movie.pojo.Movie;
import com.movie.pojo.MovieTag;
import com.movie.pojo.MovieTagMessage;
import com.movie.pojo.RecommendMovie;
import com.movie.pojo.UserMovie;
import com.movie.pojo.UserTag;
import com.movie.service.MovieService;
import com.movie.service.RecommendMovieService;
import com.movie.service.TagService;
import com.movie.service.UserMovieService;
import com.movie.service.UserTagService;
import com.movie.utils.JsonUtil;
import com.movie.utils.ListPagerUtil;
import com.movie.utils.Message;
import com.movie.utils.SortListUtil;

@Controller
@RequestMapping("/recommend")
public class RecommendMovieController {
	
	@Autowired
	private RecommendMovieService recommendMovieService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private UserMovieService userMovieService;
	
	@Autowired
	private UserTagService userTagService;
	
	@Value("${HADOOP_URL}")
	private String HADOOP_URL;
	
	@Value("${STEP1_INPUT_PATH}")
	private String STEP1_INPUT_PATH;
	
	@Value("${STEP2_INPUT_PATH}")
	private String STEP2_INPUT_PATH;
	
	@Value("${STEP1_OUTPUT_PATH}")
	private String STEP1_OUTPUT_PATH;
	
	@Value("${STEP2_OUTPUT_PATH}")
	private String STEP2_OUTPUT_PATH;
	
	@Value("${STEP3_OUTPUT_PATH}")
	private String STEP3_OUTPUT_PATH;
	
	/**
	 * 获取推荐电影信息列表
	 * @return
	 */
	@RequestMapping(value="/recommendList",method=RequestMethod.POST)
	@ResponseBody
	public Message movieList(@RequestParam(value="pageNumber",defaultValue="1") Integer pageNumber,@RequestParam("uId")Integer uId) {
		// 查询用户所有的推荐电影
		List<RecommendMovie> list = recommendMovieService.getAllRecommendListByUserId(uId);

		// 调用对象集合排序工具类对集合中的推荐评分列进行降序排列
		SortListUtil.sort(list, "recGrade", SortListUtil.DESC);
		
		List<Movie> movieList = new ArrayList<>();
		
		// 根据list集合中的电影ID查询电影信息并保存到movieList集合中
		for(int i=0;i<list.size();i++) {
			movieList.add(movieService.getSingle(list.get(i).getMovId()));
		}
		
		if(movieList.size()>0) {
			// 调用自定义的集合分页工具，传入参数要分页的集合、页码、以及每页大小
			ListPagerUtil<Movie> page = new ListPagerUtil<Movie>(movieList,pageNumber,30);
			return Message.success().add("movieList", page);
		}else {
			return Message.failed().add("msg", "还没有推荐电影，请先添加兴趣标签或直接选择电影观看！");
		}
	
	}
	
	/**
	 * 当用户观看了新电影并评分后刷新推荐电影
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/refreshRecommend",method=RequestMethod.POST)
	@ResponseBody
	public Message refreshRecommend(@RequestParam("uId")Integer uId) throws Exception {
		
		// 生成电影特征文件
		List<Movie> movies = movieService.getMovieList();
		List<MovieTag> tags = tagService.getTags();
		CreateUserInputFiles.getMovieFeature(movies, tags, uId);
		
		// 生成用户评分文件
		List<UserMovie> userMovies = userMovieService.getHistoryMovies(uId);
		CreateUserInputFiles.getUserGrade(userMovies, uId);
		
		// 上传电影特征文件、用户评分文件到HDFS,启动推荐，生成推荐结果文件并下载到系统中
		StartupRecommend.startupRecommend(uId, HADOOP_URL, STEP1_INPUT_PATH, STEP2_INPUT_PATH, STEP1_OUTPUT_PATH, STEP2_OUTPUT_PATH, STEP3_OUTPUT_PATH);
		
		// 从数据库中删除用户旧的推荐信息
		recommendMovieService.deleteAllRecommendMovieByUserId(uId);
		
		// 处理推荐结果文件并保存到集合中
		List<RecommendMovie> recommendlist = FileSaveToList.getRecommendList("RecommendResult_"+uId+".txt");
		
		// 将新的用户推荐结果保存到数据库
		for(int i=0;i<recommendlist.size();i++) {
			recommendMovieService.addAllRecommendMovie(recommendlist.get(i)); 
		}
		
		return Message.success().add("message", "刷新推荐结果成功！");
	
	}
	
	/**
	 * 当新用户添加了兴趣标签后刷新推荐电影
	 * @return
	 */
	@RequestMapping(value="/newUserRecommend",method=RequestMethod.POST)
	@ResponseBody
	public Message newUserRecommend(@RequestParam("uId")Integer uId) {
		
		List<UserTag> userTagList = userTagService.getUserTag(uId);
		
		List<MovieTag> movieTagList = tagService.getTags();
		
		List<Integer> movieTagId = new ArrayList<Integer>();
		
		for(int i=0;i<userTagList.size();i++) {
			for(int j=0;j<movieTagList.size();j++) {
				if(userTagList.get(i).getUtName().equals(movieTagList.get(j).getMtName())) {
					movieTagId.add(movieTagList.get(j).getMtId());
				}
			}
		}
		
		List<MovieTagMessage> movieTagMessageList = new ArrayList<MovieTagMessage>();
		// 一个标签id查询到一个电影信息列表，将其合并到一个列表中
		for(int j=0;j<movieTagId.size();j++) {
			List<MovieTagMessage> mtmList = userTagService.getMovieTagMessage(movieTagId.get(j));
			for(int i=0;i<mtmList.size();i++) {
				movieTagMessageList.add(mtmList.get(i));
			}
		}
		
		List<Movie> movieList = new ArrayList<Movie>();
		for(int i=0;i<movieTagMessageList.size();i++) {
			movieList.add(movieService.getSingle(movieTagMessageList.get(i).getMovId()));
		}
		
		if(movieList.size()>0) {
			return Message.success().add("movieList", movieList);
		}else {
			return Message.failed().add("msg", "还没有该类型的电影，请等待上映！");
		}
	
	}
	
}
