package com.movie.fileOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.movie.pojo.Movie;
import com.movie.pojo.MovieTag;
import com.movie.pojo.UserMovie;
import com.movie.service.TagService;
import com.movie.utils.RemoveDuplicateUtil;

/**
 * 创建所有电影的特征信息和所有用户对他所看电影的评分信息并分别保存到文件中
 * @author danbingbing
 *
 */
public class CreateUserInputFiles {

	@Autowired
	private TagService tagService;
	
	// 获取当前项目路径
	private static String path = System.getProperty("user.dir");
	
	/**
	 * 电影特征提取并保存到ItemProfile.txt文件
	 */
	public static void getMovieFeature(List<Movie> movies,List<MovieTag> tags,int uId) {
		
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<movies.size();i++) {
			int mId = movies.get(i).getmId();
			String mTag = movies.get(i).getmTag();
			
			// 按空格截取字符串
			String arr[] = mTag.split(" ");
			
			int tagId = 0;
			
			String newMtag = "";
			
			// 遍历截取后的字符串数组
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<tags.size();k++) {
					if(arr[j].equals(tags.get(k).getMtName())) {
						tagId = tags.get(k).getMtId();
						newMtag += tagId+"_1,";
					}
				}
			}
			
			// 重新拼接成新的字符串格式：标签编号_1（例：1_1,4_1,5_1,7_1）
			String finallyMtag = mId+"	"+newMtag.substring(0, newMtag.length()-1);
			// 重新拼接成新的字符串格式：标签编号_1（例：1_1,4_1,5_1,7_1）
			list.add(finallyMtag);
		}
		
		// 将数据写入到文本文件
		String fileName = path+"/userFiles/ItemProfile_"+uId+".txt";
		ListOutputToFile.coverDataToFile(list, fileName);
		
		System.out.println("ItemProfile_"+uId+".txt成功创建！");
	}
	
    /**
     * 用户对看过的电影评分记录提取并保存到ItemUser.txt文件
     */
	public static void getUserGrade(List<UserMovie> userMovies,int uId) {
    	
		int m = userMovies.size();

		String[][] arr = new String[m][2];

		// 将相同用户的观影记录信息合并
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (i != j) {
					if (userMovies.get(i).getUserId() == userMovies.get(j).getUserId()) {
						arr[j][1] = userMovies.get(j).getMovId()+"_"+userMovies.get(j).getMovGrade();
						// 需将int类型的id转为String
						arr[j][0] = userMovies.get(j).getUserId() + "";
					}
				} else {
					arr[i][1] = userMovies.get(i).getMovId()+"_"+userMovies.get(i).getMovGrade();
					arr[i][0] = userMovies.get(i).getUserId() + "";
				}
			}
		}
		// userMovies集合根据userId去重
		List<UserMovie> list = RemoveDuplicateUtil.removeDuplicate2(userMovies);
		
		List<String> gradeList = new ArrayList<>();
		
		String mGrade = "";
		
		Map<Integer,String> map = new HashMap<Integer, String>();

		// 将处理过的标签重新添加到对应的电影信息中
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < arr.length; j++) {
				if(list.get(i).getUserId()==Integer.parseInt(arr[j][0])) {
					mGrade += arr[j][1] + ",";
					map.put(list.get(i).getUserId(), mGrade);
				}
			}
			mGrade = "";
		}
		
		for (Entry<Integer, String> entry : map.entrySet()) {
			gradeList.add(entry.getKey()+"	"+entry.getValue().substring(0, entry.getValue().length()-1));
        }
		
		// 将数据写入到文本文件,有则覆盖，无则创建
		String fileName = path+"/userFiles/ItemUser_"+uId+".txt";
		ListOutputToFile.coverDataToFile(gradeList, fileName);
		
		System.out.println("ItemUser_"+uId+".txt成功创建！");
	}
	
}
