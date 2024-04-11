package Page;

import Logs.logUtils;
import com.beust.ah.A;
import keywords.DriverManager;
import keywords.WebUI;
import org.apache.commons.collections4.BagUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegisterPage {
    public final String urlRegister = "https://demo.automationtesting.in/Register.html";
    By headerRegister = By.xpath("//*[@id=\"section\"]/div/h2");
    final String headerText = "Regi-ster";
    By firstnameTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");
    By lastnameTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");
    By emailAdrressTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div");
    By emailTxt = By.xpath("//*[@id=\"eid\"]");
    //    By addressTxt=By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div");
//    By addressTxt = By.className("form-control ng-pristine ng-untouched ng-valid");
    //    By addressTxt=By.xpath("//input[@type='email']");
//    By addressTxt = By.cssSelector("div[class=form-control ng-pristine ng-untouched ng-valid]");
//    By phoneTxt = By.xpath("//body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]");
//    By firstnameTxt=By.xpath();
//    By firstnameTxt=By.xpath();
    By languageDropdownlist = By.xpath("//div[@id='msdd']");
    WebDriver driverRegister;


    public void openRegisterPage() {
        DriverManager.getDriver().get(urlRegister);
        logUtils.info("open page");
    }

    public void verifyHeaderRegisterPage() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerRegister).getText().equalsIgnoreCase(headerText), "Invalid header page!");


    }
}