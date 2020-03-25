package com.movie.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.movie.pojo.RecommendMovie;

public class FileToArrayUtil {
	
	/**
	 * 读取文件并保存到数组中(处理所有用户的推荐列表)
	 * @param filename
	 * @return String[][]
	 * @throws IOException
	 */
	public static String[][] fileToArray(String filename) throws IOException {
		String path = System.getProperty("user.dir");
		
		List<String> list1 = new ArrayList<>();
		
        FileInputStream inputStream = null;
        Scanner sc = null;
        
        inputStream = new FileInputStream(path+"/"+filename);
        sc = new Scanner(inputStream, "utf-8");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // 这里因为不知道有多少行数据，所以先保存到list集合中
            list1.add(line);
        }
        inputStream.close();
        sc.close();
        
        String[][] array = new String[list1.size()][2];
        
        for(int i=0;i<list1.size();i++) {
        	String[] arr = list1.get(i).split("	");
            for(int j=0;j<arr.length;j++) {
				// 这里 j 只等于 0 或 1
				if(j==0) { 
					array[i][0] = arr[j]; 
				}else { 
					array[i][1] = arr[j]; 
				}
				 
            }
        }
		return array;
        
	}
	
	/**
	 * 根据 user_id 返回推荐列表（可以将文件名与用户id结合形成用户的推荐文件）
	 * @throws Exception
	 */
	@Test
	public void getRecommendList() throws Exception {

		String[][] array = FileToArrayUtil.fileToArray("RecommendResult.txt");
		
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<array.length;i++) {
			// 用户id
        	if(array[i][0].equals("21")) {
        		String[] arr = array[i][1].split(",");
        		for(int j=0;j<arr.length;j++) {
        			list.add(arr[j]);
        		}
        		
        	}
        }
		
		int[][] result = new int[list.size()][3];
		
		for(int j=0;j<list.size();j++) {
			result[j][0] = 21; 
			String[] arr = list.get(j).split("_");
			for(int k=0;k<arr.length;k++) {
				if(k==0) {
					result[j][1] = Integer.parseInt(arr[k]);
				}else {
					// 根据Mapper3.java中设置的小数输出格式，这里化为整数
					result[j][2] = (int) (Float.parseFloat(arr[k]) * 1000);
				}
			}
		}
		
		List<RecommendMovie> movies = new ArrayList<>();
		
		// 将数组中的结果另存到list集合中
		for(int j=0;j<result.length;j++) {
			RecommendMovie movie = new RecommendMovie();
			movie.setUserId(result[j][0]);
			movie.setMovId(result[j][1]);
			movie.setRecGrade(result[j][2]);
			movies.add(movie);
		}
		
		// 调用对象集合排序工具类对集合中的 recommend_grade 进行降序排列
		SortListUtil.sort(movies, "recGrade", SortListUtil.DESC);
        for(RecommendMovie rm:movies) {
        	System.out.println(rm);
        }
        
	}
	
}
