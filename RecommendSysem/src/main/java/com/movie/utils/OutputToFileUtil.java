package com.movie.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.List;

public class OutputToFileUtil {
	
	/**
	 * 新数据覆盖旧数据
	 * 
	 * @param dataList
	 * @param fileName
	 * @return
	 */
	public static void coverDataToFile(List<String> dataList, String fileName) {
		OutputStreamWriter out = null;
		FileOutputStream fos = null;
		try {
			File file = new File(fileName);
			if (!file.getParentFile().isDirectory()) {
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			// 覆盖文件数据，且使用UTF-8格式
			fos = new FileOutputStream(fileName, false);
			out = new OutputStreamWriter(fos, "UTF-8");
			for (int dataIndex = 0; dataIndex < dataList.size(); dataIndex++) {
				out.write(dataList.get(dataIndex));
				out.write("\r\n");
			}
		} catch (Exception e) {

		} finally {
			try {
				if (null != out) {
					out.flush();
					out.close();
					fos.close();
				}
			} catch (IOException e) {

			}
		}
	}

	/**
	 * 数据追加写到文件末尾
	 * 
	 * @param dataList
	 * @param fileName
	 * @return
	 */
	public static void appendDataToFile(List<String> dataList, String fileName) {
		OutputStreamWriter out = null;
		FileOutputStream fos = null;
		try {
			File file = new File(fileName);
			if (!file.getParentFile().isDirectory()) {
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			// 追加写入文件，且使用UTF-8格式
			fos = new FileOutputStream(fileName, true);
			out = new OutputStreamWriter(fos, "UTF-8");
			for (int dataIndex = 0; dataIndex < dataList.size(); dataIndex++) {
				out.write(dataList.get(dataIndex));
				out.write("\r\n");
			}
		} catch (Exception e) {

		} finally {
			try {
				if (null != out) {
					out.flush();
					out.close();
					fos.close();
				}
			} catch (IOException e) {

			}
		}
	}
	
	/** 
	 * 根据java.nio.
	 * 的流获取文件大小
	 * @param file 
	 */
	public static long getFileSize(File file) {
		FileChannel fc = null;
		try {
			if (file.exists() && file.isFile()) {
				FileInputStream fis = new FileInputStream(file);
				fc = fis.getChannel();
				return fc.size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != fc) {
				try {
					fc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
