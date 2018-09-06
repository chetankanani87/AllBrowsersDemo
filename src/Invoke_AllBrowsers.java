import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Invoke_AllBrowsers {

	WebDriver driver;

	public void invokeBrowser() {
		//Way to open Firefox Browser
		//System.setProperty("webdriver.gecko.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		//Way to open Chrome Browser
		System.setProperty("webdriver.chrome.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Way to open Microsoft Edge Browser
		//System.setProperty("webdriver.edge.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\MS Edge Webdriver\\MicrosoftWebDriver.exe");
		//driver = new EdgeDriver();
		
		//Way to open Microsoft IE Browser
		//System.setProperty("webdriver.ie.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		
		//Way to open Opera Browser (below 4 lines needed)
		/*System.setProperty("webdriver.opera.driver", "C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\operadriver_win64\\operadriver.exe");
		OperaOptions options = new OperaOptions();
		options.setBinary (new File("C:\\Users\\hck\\AppData\\Local\\Programs\\Opera\\launcher.exe"));
		driver = new OperaDriver(options);*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
	}

	public void signUpFacebook() {
		try {
			driver.findElement(By.name("firstname")).sendKeys("Hiren");
			driver.findElement(By.name("lastname")).sendKeys("Patel");
			driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
			driver.findElement(By.name("reg_passwd__")).sendKeys("HiIamHereForYou");
			Select selMonth = new Select(driver.findElement(By.id("month")));
			selMonth.selectByIndex(6);
			Select selday = new Select(driver.findElement(By.id("day")));
			selday.selectByValue("21");
			Select selYear = new Select(driver.findElement(By.id("year")));
			selYear.selectByVisibleText("1963");
			driver.findElement(By.xpath("//*[@id=\"u_0_a\"]")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Invoke_AllBrowsers fb = new Invoke_AllBrowsers();
		fb.invokeBrowser();
		fb.signUpFacebook();
		fb.closeBrowser();
	}

}
