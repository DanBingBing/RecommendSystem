package com.movie.utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorConfigUtil {
	
	/**
	 * 逆向工程，自动生成对象关系映射相关文件
	 * @param args
	 * @throws IOException
	 * @throws XMLParserException
	 * @throws SQLException
	 * @throws InterruptedException
	 * @throws InvalidConfigurationException
	 */
	@Test
	public void GeneratorRun() throws IOException, XMLParserException, SQLException, InterruptedException, InvalidConfigurationException {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("generator-config.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		
		System.out.println("逆向工程，自动生成对象关系映射相关文件完成！");
	}
}
