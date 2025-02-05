package com.movie.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * 
 * cos<步骤1输入,步骤2输出>
 */
public class Reducer3 extends Reducer<Text, Text, Text, Text> {
	private Text outKey = new Text();
	private Text outValue = new Text();

	// key:行 物品ID value:列_值 用户ID_分值
	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		StringBuilder sb = new StringBuilder();

		for (Text text : values) {
			sb.append(text + ",");
		}

		String line = null;
		if (sb.toString().endsWith(",")) {
			line = sb.substring(0, sb.length() - 1);
		}

		outKey.set(key);
		outValue.set(line);

		context.write(outKey, outValue);
	}

}
