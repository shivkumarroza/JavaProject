package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil {
	public static String getProperty(String path,String key)
	{
		String value="";
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(path));
			value=prop.getProperty(key);
		} catch (Exception e) {
			
		}
		return value;
	}
	
	public static void getPhoto(WebDriver driver,String folder, String testName)
	{
		Date d=new Date();
		String sdate=d.toString();
		String dateTime=sdate.replaceAll(":", "_");
		String path=folder+testName+dateTime+".png";
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destiFile=new File(path);
		try {
			FileUtils.copyFile(srcFile, destiFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
