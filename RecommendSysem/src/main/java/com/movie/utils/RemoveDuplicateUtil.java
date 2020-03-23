package com.movie.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.movie.pojo.MovieTagMessage;
import com.movie.pojo.UserMovie;

/**
 * 删除 list 集合中重复的元素
 *
 */
public class RemoveDuplicateUtil {

	/**
	 * list集合数据去重
	 * @param list
	 * @return
	 */
	public static List removeDuplicate(List list) {
	    
		HashSet set = new HashSet(list);
	    list.clear();
	    list.addAll(set);
	    return list;
	}
	
	/**
	 * 根据list中的字段去重
	 * @param list
	 * @return
	 */
	public static List<MovieTagMessage> removeDuplicate1(List<MovieTagMessage> list) {
	    
		List<MovieTagMessage> list2 = new ArrayList<>();
		
		/*List<Integer> list3 = new ArrayList<>();
		
		// 取出所有mov_id,去除重复,并按自然数的顺序存储
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i=0;i<list.size();i++) {
			set.add(list.get(i).getMovId());
		}*/
		
		list2 = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MovieTagMessage :: getMovId))), ArrayList::new));
		
	    return list2;
	}
	
	public static List<UserMovie> removeDuplicate2(List<UserMovie> list) {
	    
		List<UserMovie> list2 = new ArrayList<>();
		
		list2 = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserMovie :: getUserId))), ArrayList::new));
		
	    return list2;
	}

}
