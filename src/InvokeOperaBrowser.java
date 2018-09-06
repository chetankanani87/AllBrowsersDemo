import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class InvokeOperaBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.opera.driver", "C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\operadriver_win64\\operadriver.exe");
		OperaOptions options = new OperaOptions();
		options.setBinary (new File("C:\\Users\\hck\\AppData\\Local\\Programs\\Opera\\launcher.exe"));
		WebDriver driver = new OperaDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
		
		driver.close();
		
	}

}
