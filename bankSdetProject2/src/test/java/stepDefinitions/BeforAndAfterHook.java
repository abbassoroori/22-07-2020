package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import core.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforAndAfterHook extends Base {
	@Before
	public void beforeHook() throws Throwable{
		if (Base.getBrowser().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
		}
		else if (Base.getBrowser().equalsIgnoreCase("ie")) {WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		}
		else if(Base.getBrowser().equalsIgnoreCase("ff")) {WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		else if (Base.getBrowser().equalsIgnoreCase("edge")) {WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(getImplicit(), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@After
	public void afterHook()throws Throwable {
		driver.close();
		driver.quit();
	}

}
