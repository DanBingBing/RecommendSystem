package com.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.utils.Message;
import com.movie.utils.RemoveDuplicateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.pojo.Movie;
import com.movie.pojo.MovieTagMessage;
import com.movie.service.MovieService;
import com.movie.utils.JsonUtil;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * 获取完整电影信息列表
	 * @return
	 */
	@RequestMapping("/movieList")
	@ResponseBody
	public Message movieList(@RequestParam(value="pageNumber",defaultValue="1") Integer pageNumber) {
		
		// 在查询之前调用，传入页码、以及每页大小
		PageHelper.startPage(pageNumber, 30);
		
		// 该list封装了所有的电影信息
		List<Movie> movieList = movieService.getMovieList();

		// 使用pageInfo来封装list集合
		// 因为它里面封装了可在页面使用的数据信息（包括详细的分页信息及查询到的数据）,传入分页导航栏显示的页码数
		PageInfo<Movie> page = new PageInfo<Movie>(movieList,5);
		
	
		return Message.success().add("movieList", page);
	}
	
	/**
	 * 获取单个电影信息
	 * @return
	 */
	@RequestMapping("/getSingle")
	@ResponseBody
	public Message getSingle(Movie movie) {
		
		Integer mId = movie.getmId();
		
		// 该list封装了所有的电影信息
		Movie singleMovie = movieService.getSingle(mId);
	
		return Message.success().add("movie", singleMovie);
	}
	
	/**
	 * 根据电影名称获取电影信息列表（模糊查询）
	 * @return
	 */
	@RequestMapping("/searchList")
	public String searchList(Movie movie,Model model) {
		// 该list封装了查询到的所有电影信息
		List<Movie> searchList = movieService.getSearchList(movie.getmName());
		model.addAttribute("movieList", searchList);
		
		return "searchList";
	}
	
	/**
	 * 获取推荐电影信息列表
	 * @return
	 */
	@RequestMapping("/recommendList")
	@ResponseBody
	public Message recommendList() {
		
		// 该list封装了所有的电影信息
		List<Movie> movieList = movieService.getMovieList();
	
		return Message.success().add("movieList", movieList);
	}

	/**
	 * 级联查询获取电影信息列表及初始化电影综合标签信息
	 * @return
	 */
	public Message updateMTag() {
		
		// 该list封装了所有的电影信息，包括id相同的，只有tag不同的
		List<MovieTagMessage> movieList = movieService.getAllMovies();

		// 不可取，这是引用了movieList的地址，当对recommendList操作（增加、删除等）也会影响movieList
		// List<MovieTagMessage> recommendList = movieList;

		int m = movieList.size();

		String[][] tagStr = new String[m][2];

		// 将相同电影的单个标签合并
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (i != j) {
					if (movieList.get(i).getMovId() == movieList.get(j).getMovId()) {
						tagStr[j][1] = movieList.get(j).getMovieTag().getMtName();
						tagStr[j][0] = movieList.get(j).getMovId() + "";
					}
				} else {
					tagStr[i][1] = movieList.get(i).getMovieTag().getMtName();
					tagStr[i][0] = movieList.get(i).getMovId() + "";
				}
			}
		}

		// 将list集合去重工具类RemoveDuplicateUtil1返回的一个新集合响应到页面
		List<MovieTagMessage> list = new ArrayList<MovieTagMessage>();
		list = RemoveDuplicateUtil.removeDuplicate1(movieList);

		String tag = "";

		// 将处理过的标签重新添加到对应的电影信息中
		for (int i = 0; i < list.size(); i++) {

			for (int j = 0; j < list.size(); j++) {
				if (list.get(i).getMovId() == Integer.parseInt(tagStr[j][0])) {
					tag += (tagStr[j][1] + " ");
					list.get(i).getMovieTag().setMtName(tag);
					// System.out.println(tag);
				} else {
					tag = "";
				}
			}

		}

		String mTag = null;
		int mId = 0;

		// 将得到的综合标签更新到电影信息中
		for (int i = 0; i < list.size(); i++) {
			mTag = list.get(i).getMovieTag().getMtName();
			mId = list.get(i).getMovId();
			movieService.setMtagByMid(mId, mTag);
		}
		return Message.success().add("msg", "电影综合标签信息更新成功！");
	}
}
