package common;

import Helpers.CaptureHelper;
import keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

import keywords.DriverManager;


public class BaseTest {


    @BeforeMethod(alwaysRun = true)
    public void createBrowser() {
        WebDriver driver;// phải là biến local

        System.out.println("Start with test");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        DriverManager.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult rs, Method m) {
        WebUI.sleep(2);
        if (rs.getStatus() == ITestResult.FAILURE) {
//            CaptureHelper.captureScreenshot(m.getName(),DriverManager.getDriver());
            CaptureHelper.stopRecord();
        }

        System.out.println("Close browser from BaseTest...");
        DriverManager.quite();
    }

}


