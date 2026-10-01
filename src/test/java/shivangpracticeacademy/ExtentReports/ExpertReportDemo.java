package shivangpracticeacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpertReportDemo {
	ExtentReports extent; 
	@BeforeTest
	public void config() {
		
		//ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Reults");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shivang Gupta");
	}
	
	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
	//	test.addScreenCaptureFromBase64String(null)
		driver.close();
		test.fail("Result do no match");
		extent.flush();
		 
	}

}
