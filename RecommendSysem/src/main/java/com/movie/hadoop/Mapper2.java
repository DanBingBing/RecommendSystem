package com.movie.hadoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * item user (评分矩阵) × item profile（已转置）
 */
public class Mapper2 extends Mapper<LongWritable, Text, Text, Text> {
	private Text outKey = new Text();
	private Text outValue = new Text();
	private List<String> cacheList = new ArrayList<String>();

	private DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * 在map执行之前会执行这个方法，只会执行一次
	 * 
	 * 通过输入流将全局缓存中的矩阵读入一个java容器中
	 */
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		super.setup(context);
		FileReader fr = new FileReader("itemUserScore1");
		BufferedReader br = new BufferedReader(fr);

		// 右矩阵
		// key:行号 物品ID value:列号_值,列号_值,列号_值,列号_值,列号_值... 用户ID_分值
		String line = null;
		while ((line = br.readLine()) != null) {
			cacheList.add(line);
		}

		fr.close();
		br.close();
	}

	/**
	 * key: 行号 物品ID value:行 列_值,列_值,列_值,列_值 用户ID_分值
	 */
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String[] rowAndLine_matrix1 = value.toString().split("\t");

		// 矩阵行号
		String row_matrix1 = rowAndLine_matrix1[0];
		// 列_值
		String[] cloumn_value_array_matrix1 = rowAndLine_matrix1[1].split(",");

		for (String line : cacheList) {

			String[] rowAndLine_matrix2 = line.toString().split("\t");
			// 右侧矩阵line
			// 格式: 列 tab 行_值,行_值,行_值,行_值
			String cloumn_matrix2 = rowAndLine_matrix2[0];
			String[] row_value_array_matrix2 = rowAndLine_matrix2[1].split(",");

			// 矩阵两位相乘得到的结果
			double result = 0;

			// 遍历左侧矩阵一行的每一列
			for (String cloumn_value_matrix1 : cloumn_value_array_matrix1) {
				String cloumn_matrix1 = cloumn_value_matrix1.split("_")[0];
				String value_matrix1 = cloumn_value_matrix1.split("_")[1];

				// 遍历右侧矩阵一行的每一列
				for (String cloumn_value_matrix2 : row_value_array_matrix2) {
					if (cloumn_value_matrix2.startsWith(cloumn_matrix1 + "_")) {
						String value_matrix2 = cloumn_value_matrix2.split("_")[1];
						// 将两列的值相乘并累加
						result += Double.valueOf(value_matrix1) * Double.valueOf(value_matrix2);

					}
				}
			}

			if (result == 0) {
				continue;
			}
			// result就是结果矩阵中的某个元素，坐标 行：row_matrix1 列：row_matrix2（右侧矩阵已经被转置）
			outKey.set(row_matrix1);
			outValue.set(cloumn_matrix2 + "_" + df.format(result));
			// 输出格式为 key:行 value:列_值
			context.write(outKey, outValue);
		}
	}
}
