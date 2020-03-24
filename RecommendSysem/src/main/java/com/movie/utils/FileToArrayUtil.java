package com.movie.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class FileToArrayUtil {
	
	public static String[][] fileToArray(String filename) throws IOException {
		String path = System.getProperty("user.dir");
		
		List<String> list = new ArrayList<>();
		
        FileInputStream inputStream = null;
        Scanner sc = null;
        
        inputStream = new FileInputStream(path+"/"+filename);
        sc = new Scanner(inputStream, "utf-8");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // 这里因为不知道有多少行数据，所以先保存到list集合中
            list.add(line);
        }
        inputStream.close();
        sc.close();
        
        String[][] array = new String[list.size()][2];
        
        for(int i=0;i<list.size();i++) {
        	String[] arr = list.get(i).split("	");
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
	
	@Test
	public void run() throws Exception {
		String[][] array = FileToArrayUtil.fileToArray("ReecommendResult.txt");
		
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
		
		int[][] result = new int[list.size()][2];
		
		for(int j=0;j<list.size();j++) {
			String[] arr = list.get(j).split("_");
			for(int k=0;k<arr.length;k++) {
				if(k==0) {
					result[j][0] = Integer.parseInt(arr[k]);
				}else {
					// 根据Mapper3.java中设置的小数输出格式，这里化为整数
					result[j][1] = (int) (Float.parseFloat(arr[k]) * 1000);
				}
			}
		}
		int [] gradeSort = new int[result.length];
		for(int j=0;j<result.length;j++) {
			gradeSort[j] = result[j][1];
		}
		
		Arrays.sort(gradeSort);
		for(int j=0;j<gradeSort.length;j++) {
			System.out.println(gradeSort[j]);
		}
		
	}
	
}
