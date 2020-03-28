package com.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.movie.pojo.RecommendMovie;
import com.movie.pojo.UserMovie;
import com.movie.service.MovieService;
import com.movie.service.RecommendMovieService;
import com.movie.service.TagService;
import com.movie.service.UserMovieService;
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
	
	/**
	 * 获取推荐电影信息列表
	 * @return
	 */
	@RequestMapping(value="/recommendList",method=RequestMethod.POST)
	@ResponseBody
	public Message movieList(@RequestParam(value="pageNumber",defaultValue="1") Integer pageNumber,@RequestParam("uId")Integer uId) {
		// 查询用户所有的推荐电影
		List<RecommendMovie> list = recommendMovieService.getAllRecommendListByUserId(uId);

		// 调用对象集合排序工具类对集合中的 recGrade 进行降序排列
		SortListUtil.sort(list, "recGrade", SortListUtil.DESC);
		
		// 该list封装了所有的电影信息
		List<Movie> movieList = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			movieList.add(movieService.getSingle(list.get(i).getMovId()));
		}
		
		// 调用自定义的集合分页工具，传入参数要分页的集合、页码、以及每页大小
		// （伪分页，表示依然要从数据库查询所有的数据保存到集合中，对集合进行分页，主要用于信息量不大的数据）
		ListPagerUtil<Movie> page = new ListPagerUtil<Movie>(movieList,pageNumber,30);
				
		System.out.println(JsonUtil.objectToJson(page));
		return Message.success().add("movieList", page);
	
	}
	
	/**
	 * 当用户观看了新电影并评分后刷新推荐电影
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/refreshRecommend",method=RequestMethod.POST)
	@ResponseBody
	public Message refreshRecommend(@RequestParam("uId")Integer uId) throws Exception {
		// 从数据库中删除用户旧的推荐信息
		recommendMovieService.deleteAllRecommendMovieByUserId(1);
		// 从数据库中删除用户旧的推荐信息
		recommendMovieService.deleteAllRecommendMovieByUserId(2);
		
		// 生成电影特征文件
		List<Movie> movies = movieService.getMovieList();
		List<MovieTag> tags = tagService.getTags();
		CreateUserInputFiles.getMovieFeature(movies, tags, uId);
		
		// 生成用户评分文件
		List<UserMovie> userMovies = userMovieService.getHistoryMovies(uId);
		CreateUserInputFiles.getUserGrade(userMovies, uId);
		
		// 上传电影特征文件、用户评分文件到HDFS,启动推荐，生成推荐结果文件并下载到系统中
		StartupRecommend.startupRecommend("ItemProfile_"+uId+".txt", "ItemUser_"+uId+".txt", "RecommendResult_"+uId);
		
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
}
