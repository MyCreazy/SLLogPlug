package com.sl.SLLogPlug;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * 日志对象
	 */
	// private static Logger logger = LogManager.getLogger(App.class);

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	/**
	 * 初始化日志
	 * 
	 * @throws FileNotFoundException
	 */
	private static void initlogbygetresource() throws FileNotFoundException {
		String path = "/src/main/resources/log4j2.xml";
		URL url = App.class.getResource(path);
		ConfigurationSource source = new ConfigurationSource(new FileInputStream(new File(url.getPath())), url);
		Configurator.initialize(null, source);
	}

	/**
	 * 通过属性配置文件初始化
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void initlogbygetproerty() throws FileNotFoundException, IOException {
		String config = System.getProperty("user.dir");
		ConfigurationSource source = new ConfigurationSource(
				new FileInputStream(config + "/src/main/resources/log4j2.xml"));
		Configurator.initialize(null, source);
	}

	/**
	 * 绝对路径进行初始化
	 */
	private static void initlogbyAbsolutely() {
		try {
			ConfigurationSource source = new ConfigurationSource(new FileInputStream("D:\\log4j2.xml"));
			Configurator.initialize(null, source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * main函数
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int countnum = 0;
		try {
			int dd = 5 / 0;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		logger.warn("测试成功:" + countnum, new Exception("d"));
		logger.debug("测试成功:" + countnum);

		logger.info("测试成功:" + countnum);
		System.out.println("Hello World!");
	}
}
