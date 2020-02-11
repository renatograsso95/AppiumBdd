package br.com.rsinet.hub_bdd.extendReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Prints {

	/* Atribui data e hora ao nomear o arquivo de print. */
	public static String timestamp() {
		return new SimpleDateFormat(" yyyy-MM-dd HH-mm-ss").format(new Date());
	}


	public static String getScreens(WebDriver driver, String pic) throws Exception {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/target/" + pic + timestamp() + ".png";

        try {
            FileUtils.copyFile(file, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
	}
}
