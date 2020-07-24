package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Base {
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	//private String userdirectory = System.getProperty("user.dir");
//	private String pathToFile = "src\\test\\resources\\inputData\\bankProject.properties";
	//private String pathToPP = userdirectory + pathToFile;
	private static String pathToPP=".\\src\\test\\resources\\inputData\\bankProject.properties";

	public Base() {
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(pathToPP));

			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		logger = Logger.getLogger("file4j_File");
		PropertyConfigurator.configure(".\\src\\test\\resources\\inputData\\log4j.properties");

	}

	public static String getUrl1() {
		String url1 = properties.getProperty("url1");
		return url1;
	}

	public static String getUrl2() {
		String url2 = properties.getProperty("url2");
		return url2;

	}

	public static String getUrl3() {
		String url3 = properties.getProperty("url3");
		return url3;
	}

	public static String getUrl4() {
		String url4 = properties.getProperty("url4");
		return url4;
	}
	public static String getBrowser() {
		String browser=properties.getProperty("browser");
		return browser;
	}

	public static long getImplicit() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(implicitlyWait);
	}

	public static long getPageLoadTime() {
		String pageLoadTime = properties.getProperty("implicitlyWait");
		return Long.parseLong(pageLoadTime);

	}

	public static void initilizeUrl1() {
		driver.get(getUrl1());
	}

	public static void initilizeUrl2() {
		driver.get(getUrl2());
	}

	public static void initilizeUrl3() {
		driver.get(getUrl3());
	}

	public static void initilizeUrl4() {
		driver.get(getUrl4());
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}