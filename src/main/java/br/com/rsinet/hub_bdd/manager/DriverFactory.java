package br.com.rsinet.hub_bdd.manager;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	private WebDriver driver;
	
	@SuppressWarnings({ "rawtypes" })
	public WebDriver iniciaApp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "com.Advantage.aShopping");
		capabilities.setCapability("appActivity", ".SplashActivity");
		capabilities.setCapability("unicodeKeyboard", true);

		if (driver == null)
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		return driver;
	}

	public WebDriver closeDriver() {
		if (driver != null) {	
			driver.quit();
		}
		return driver;
	}
}