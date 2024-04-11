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

    public void verifyPlaceHolderFirstname() {
        Assert.assertEquals(DriverManager.getDriver().findElement(firstnameTxt).getAttribute("Placeholder"), "First Name", "Invalid First name placeholder!");

    }

    public void verifyPlaceHolderLastname() {
        Assert.assertEquals(DriverManager.getDriver().findElement(lastnameTxt).getAttribute("Placeholder"), "Last Name", "Invalid Last name Placeholder!");

    }

    By fullnameLabel = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/label");
    By emailAddressLabel = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[3]/label");
    By phoneLabel = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/label");
    By genderLabel = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/label");

    public void verifyMandotoryFields() {
        System.out.println(DriverManager.getDriver().findElement(fullnameLabel).getText().endsWith("*"));
        System.out.println(DriverManager.getDriver().findElement(fullnameLabel).getText());

        Assert.assertTrue(DriverManager.getDriver().findElement(fullnameLabel).getText().contains("*"), "Not mandatory");
        Assert.assertTrue(DriverManager.getDriver().findElement(emailAddressLabel).getText().contains("*"), "Not mandatory");
        Assert.assertTrue(DriverManager.getDriver().findElement(phoneLabel).getText().contains("*"), "Not mandatory");
        Assert.assertTrue(DriverManager.getDriver().findElement(genderLabel).getText().contains("*"), "Not mandatory");
    }

    ///kểm tra all feilds
    public void verifyDefaultFields() {
        SoftAssert softAssert = new SoftAssert();
        //dùng is empty ko dùng is blank (isblank trả về true, ko chứa whtespace)
        Assert.assertTrue(DriverManager.getDriver().findElement(lastnameTxt).getText().isEmpty(), "Field is not null");
        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());
        softAssert.assertTrue(DriverManager.getDriver().findElement(firstnameTxt).getText().isEmpty(), "Field is not null");
        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());

        softAssert.assertTrue(DriverManager.getDriver().findElement(emailTxt).getText().isEmpty(), "Field is not null");
        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());

        By addressTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div");
        softAssert.assertTrue(DriverManager.getDriver().findElement(addressTxt).getText().isEmpty(), "Field is not null");
        System.out.println(DriverManager.getDriver().findElement(lastnameTxt).getText());
        By phoneTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");
        Assert.assertTrue(DriverManager.getDriver().findElement(phoneTxt).getText().isEmpty(), "Field is not null");
//        Assert.assertTrue(DriverManager.getDriver().findElement(lastnameTxt).getText().isEmpty(),"Field is not null");

    }

    public void veirfyEnteredData(String first_name, String last_name, String address, String email_address, String phone, String gender, String hobby, String language, String skill, String country, String dof, String password, String repassword) {

        DriverManager.getDriver().findElement(firstnameTxt).sendKeys(first_name);
        DriverManager.getDriver().findElement(lastnameTxt).sendKeys(last_name);
//        DriverManager.getDriver().findElement(addressTxt).sendKeys(address);
        DriverManager.getDriver().findElement(emailTxt).sendKeys(email_address);
        DriverManager.getDriver().findElement(phoneTxt).sendKeys(phone);

    }

    //    By phoneTxt=By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");
    By inputPhone = By.cssSelector("input[tag='tel']");
    By addressTxt = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea");
    By phoneTxt = By.xpath("//input[@type='tel']");

    public void veirfyEnteredData(String first_name, String last_name, String address, String email_address, String phone) {
        DriverManager.getDriver().findElement(firstnameTxt).sendKeys(phone);
        WebUI.sleep(2);
        DriverManager.getDriver().findElement(lastnameTxt).sendKeys(last_name);
        WebUI.sleep(2);
        DriverManager.getDriver().findElement(addressTxt).sendKeys(email_address);
        WebUI.sleep(2);
        DriverManager.getDriver().findElement(phoneTxt).sendKeys(phone);
        WebUI.sleep(2);

        DriverManager.getDriver().findElement(emailTxt).sendKeys(email_address);
        WebUI.sleep(2);
    }

    public void testLocator() {
//        WebUI.sleep(7);
//        By e = By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[1]");
//        DriverManager.getDriver().findElement(addressTxt).sendKeys("123");
//        DriverManager.getDriver().findElement(phoneTxt).sendKeys("123");
//        WebUI.sleep(5);

//        DriverManager.getDriver().findElement(emailAdrressTxt).sendKeys("123");

//        DriverManager.getDriver().findElement(emailTxt);
//        WebUI.waitForElementVisible(DriverManager.getDriver(),(By.xpath("//div[@id='eid']")),30);
//        DriverManager.getDriver().findElement(By.cssSelector("//*[@id=\"eid\"]")).sendKeys("123");
//        DriverManager.getDriver().findElement(By.xpath("//div[@id='eid']")).sendKeys("456");
//        DriverManager.getDriver().findElement(By.cssSelector("input[type='email']")).sendKeys("456");
//        WebUI.sleep(2);
//        DriverManager.getDriver().findElement(lastnameTxt).sendKeys("heelo");

//        DriverManager.getDriver().findElement(e).sendKeys("123");
        By by = By.xpath("//div[@id='msdd']");
        WebElement ele = DriverManager.getDriver().findElement(by);
        ele.click();
    }

    By maleCkb = By.xpath("//input[@value='Male']");
    By femaleCkb = By.xpath("//input[@value='FeMale']");
    WebElement maleCkbE;
    WebElement femaleCkbE;

    //khai báo ở ngao2i không chạy được không hiểu, chắc lquan đến driver
    public void verifyGenderCheckboxDefauilt() {
        maleCkbE = DriverManager.getDriver().findElement(maleCkb);
        femaleCkbE = DriverManager.getDriver().findElement(femaleCkb);
        Assert.assertFalse(maleCkbE.isSelected(), "Male check box is selected");
        Assert.assertFalse(femaleCkbE.isSelected(), "Female chack box is selected");
        WebUI.sleep(10);

    }

    public void EnteredData(String gender) {
        openRegisterPage();

        maleCkbE = DriverManager.getDriver().findElement(maleCkb);
        femaleCkbE = DriverManager.getDriver().findElement(femaleCkb);

        if (gender.equalsIgnoreCase("male")) {
            maleCkbE.click();
            System.out.println("male");
            Assert.assertTrue(maleCkbE.isSelected(), "Male is nt selected");
        } else if (gender.equalsIgnoreCase("female")) {
            femaleCkbE.click();
            System.out.println("female");
            Assert.assertTrue(femaleCkbE.isSelected());
        } else {
            System.out.println("OTher");
        }

    }


    //*[@id="basicBootstrapForm"]/div[7]/div/multi-select/div[2]/ul
    public void Enteredlanguage(String languge) {
        openRegisterPage();
        WebElement ele = DriverManager.getDriver().findElement(languageDropdownlist);
        ele.click();
        //vietnameese chọn rồi click
        By by1 = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[41]/a");
        DriverManager.getDriver().findElement(by1).click();


    }

    //languege dropdownllist
    By listLanguage = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul");

    public void printAllLanguage() {
        openRegisterPage();

        WebElement dropdownElement = DriverManager.getDriver().findElement(languageDropdownlist);
        dropdownElement.click();
        //khi click vao element thì xpath dưới mới hiển thị ra và lấy data, if not click, error
        List<WebElement> options = dropdownElement.findElements(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul"));

        List<String> dropdownData = new ArrayList<>();
        for (WebElement option : options) {
            String optionText = option.getText();
            dropdownData.add(optionText);
        }

        for (String data : dropdownData) {
            System.out.println(data);
        }
    }

    public void verifyLanguageMutliSelect(String a, String b) {
        openRegisterPage();
        //scroll down to see fields

        WebElement ele = DriverManager.getDriver().findElement(languageDropdownlist);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);

        ele.click();
        WebUI.sleep(2);
//        Select select = new Select(ele);
//        Assert.assertTrue(select.isMultiple(), "Language isn't allow mutli select");
        //khong dung duoc vi no không phải <select> trong html nó là thẻ div
        //không dùng được lun
//        List<WebElement> listEle = ele.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']"));
//        for (WebElement option : listEle) {
//            if (option.getAttribute("value").equalsIgnoreCase("vietnamese") ||
//                    option.getAttribute("value").equalsIgnoreCase("chinese")) {
//                option.click();
//            }


//dùng js
//        By araLanguage=By.xpath("//a[normalize-space()='Arabic']");
        //*[@id="basicBootstrapForm"]/div[7]/div/multi-select/div[2]/ul/li[41]/a
        //a[normalize-space()='Vietnamese']
        String value1 = a;
        WebElement ele1 = DriverManager.getDriver().findElement(By.xpath("//a[normalize-space()='" + value1 + "']"));
        String value2 = b;
        WebElement ele2 = DriverManager.getDriver().findElement(By.xpath("//a[normalize-space()='" + value2 + "']"));

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", ele1);
        js.executeScript("arguments[0].click();", ele2);
//verify sao ta?? by rice
        // Validate selected options, selectting two things are the same is wrong
//        Assert.assertTrue(ele1.getAttribute("class").contains("selected"));
//        Assert.assertTrue(ele2.getAttribute("class").contains("selected"));


    }

    By skillDropdownlist = By.xpath("//select[@id='Skills']");
    By skillLabel = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[8]/label");

    public void verifyDefaultSkills() {
        openRegisterPage();
        WebElement ele = DriverManager.getDriver().findElement(skillDropdownlist);
        Select select = new Select(ele);
        String defaultSkills = select.getFirstSelectedOption().getText();
//        System.out.println(select.getAllSelectedOptions());
        Assert.assertTrue(defaultSkills.equalsIgnoreCase("Select Skills"), "Invalid Default Skills ");

    }

    // 2 phương án: lấy dữ liệu từ excel và gán vào xpath như đã làm ở phần Language
    // phương án 2 là tự nó click chọn data tùy ý và gửi về lại excel
    //tạo hàm scroll down
    public void verifySkillsDropdowlList(String a) {
        openRegisterPage();
        WebElement ele = DriverManager.getDriver().findElement(skillDropdownlist);// thẻ select á thẻ khác thì ko dùng hàm select được
        Select select = new Select(ele);
        ////option[@value='Adobe InDesign']
        select.selectByVisibleText(a);


    }

    public void getAllSkills() {
        openRegisterPage();
        WebElement ele = DriverManager.getDriver().findElement(skillDropdownlist);
        Select select = new Select(ele);
        List<WebElement> option = select.getOptions();
        for (WebElement op : option) {
            System.out.println(op.getText());
        }
    }

    //nếu có tgianviet6t hàm láy dũ liệu về file excel
    public String extractDataFromWebsite() {
        openRegisterPage();
        // Locate and extract the desired data
        WebElement dataElement = DriverManager.getDriver().findElement(skillDropdownlist);
        String data = dataElement.getText();

        return data;
    }

    By countryDl = By.xpath("//*[@id=\"country\"]");
    By countryLbl = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/label");

    By countryDefault = By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']");

    //chưa clear
    public void verifyDefaultCountry() {
        openRegisterPage();
        //xpath này đúng
//        By countryDl = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div");
        By countryDl = By.xpath("//*[@id=\"country\"]");
        WebElement ele = DriverManager.getDriver().findElement(countryDl);

        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
        System.out.println(ele.getText());
        Assert.assertNull(ele.getText().isEmpty(), "Invalid Default Country field");

        ele.click();
    }

    public void verifyCountryDroplist(String a) {
        openRegisterPage();
        WebElement ele = DriverManager.getDriver().findElement(countryDl);
        Select select = new Select(ele);
        select.selectByVisibleText(a);
        WebUI.sleep(2);
    }

    By yearDl = By.xpath("//*[@id=\"yearbox\"]");
    By monthDl = By.xpath("//select[@placeholder='Month']");
    //cái này sai
//    By monthDl = By.xpath("//*[@id=\"monthbox\"]");
    By dayDl = By.xpath("//*[@id=\"daybox\"]");

    public void getAllDateDate() {
        openRegisterPage();
        WebElement ele1 = DriverManager.getDriver().findElement(yearDl);
        //scroll down to see fields
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele1);

        WebElement ele2 = DriverManager.getDriver().findElement(monthDl);
        WebElement ele3 = DriverManager.getDriver().findElement(dayDl);
        System.out.println(ele1.getText());
        System.out.println(ele2.getText());
        System.out.println(ele3.getText());

    }

    public void verifyDate(String m, String d, String y) {
        //phải click mới chạy đc
        openRegisterPage();
        WebElement ele1 = DriverManager.getDriver().findElement(yearDl);
        //scroll down to see fields
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele1);
        ele1.click();
        WebUI.sleep(3);

        Select selectY = new Select(ele1);
        selectY.selectByVisibleText(y);
        WebElement ele2 = DriverManager.getDriver().findElement(monthDl);
        ele2.click();
        WebUI.sleep(3);
        Select selectM = new Select(ele2);
        selectM.selectByVisibleText(m);
        WebElement ele3 = DriverManager.getDriver().findElement(dayDl);
        ele3.click();
        WebUI.sleep(3);
        Select selectD = new Select(ele3);
        selectD.selectByVisibleText(d.toString());
        WebUI.sleep(3);

    }

    public void verifyDefaultDate() {
        //phải click mới chạy đc
        openRegisterPage();
        WebElement ele1 = DriverManager.getDriver().findElement(yearDl);
        //scroll down to see fields
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele1);

        Select selectY = new Select(ele1);
        String defaultY = selectY.getFirstSelectedOption().getText();
        Assert.assertTrue(defaultY.equalsIgnoreCase("Year"), "Invalid default Year field");
        WebElement ele2 = DriverManager.getDriver().findElement(monthDl);
        Select selectM = new Select(ele2);
        String defaultM = selectM.getFirstSelectedOption().getText();
        Assert.assertTrue(defaultM.equalsIgnoreCase("Month"), "Invalid default Month field");
        WebElement ele3 = DriverManager.getDriver().findElement(dayDl);
        Select selectD = new Select(ele3);
        String defaultD = selectD.getFirstSelectedOption().getText();
        Assert.assertTrue(defaultD.equalsIgnoreCase("Day"), "Invalid default Day field");

    }

    public void verifySearchCountry(String au) {
        openRegisterPage();
        By countryDl = By.xpath("//span[@role='combobox']");
        WebElement eleCountryDl = DriverManager.getDriver().findElement(countryDl);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", eleCountryDl);
        WebUI.sleep(3);
        eleCountryDl.click();
        //enter valid
        By countryTxt = By.xpath("//input[@role='textbox']");
        WebElement eleTxt = DriverManager.getDriver().findElement(countryTxt);
        eleTxt.sendKeys(au);
        WebUI.sleep(2);
// luc1 đunúng lúc sai
//WebElement firstOp=DriverManager.getDriver().findElement(By.xpath("//*[@id=\"country\"]/option[1]"));
//        String str=firstOp.getText();
//        By resultSearch = By.xpath("//*[@id=\"select2-country-results\"]/li");
//        DriverManager.getDriver().findElement(resultSearch).click();
//        By resultSearchSecond=By.xpath("//*[@id=\"select2-country-results\"]/li[2]");
//        DriverManager.getDriver().findElement(resultSearchSecond).click();
//
//        By listResultSearch = By.xpath("//*[@id=\"select2-country-results\"]");
        By listResultLocator = By.className("select2-results__options");
        List<WebElement> listResult = DriverManager.getDriver().findElements(listResultLocator);
        Integer toltalResult = listResult.size();
        System.out.println(toltalResult);
        String currentRes = null;
        for (WebElement elee : listResult) {

            currentRes = elee.getText();
            if (currentRes.contains(au)) {
                toltalResult++;
                Assert.assertTrue(currentRes.contains(au), "Not match result search");
                elee.click();
                WebUI.sleep(2);
                break;
            }

        }
        Assert.assertTrue(toltalResult != 0, "Not found result");
//        WebElement optionSecond = DriverManager.getDriver().findElement(resultSearchSecond);
        //verifyResultReturn
        By confirmLactor = By.xpath("//*[@id=\"select2-country-container\"]");
        WebElement confirmResult = DriverManager.getDriver().findElement(confirmLactor);
        Assert.assertTrue(confirmResult.getText().equalsIgnoreCase(currentRes), "Result search not match");
    }

    public void verifyDefaultField(By by, Method method) {
        openRegisterPage();

        WebElement passEle = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", passEle);

        Assert.assertTrue(passEle.getText().isEmpty(), method.getName() + "invalid");
        System.out.println(method.getName() + passEle.getText());


    }

    By passTxt = By.id("firstpassword");
    By repasswordTxt = By.id("secondpassword");

    public void verifyDefaultPasswordFiled(Method method) {
        verifyDefaultField(passTxt, method);

    }


    public void verifyDefaultRePasswordFiled(Method method) {
        openRegisterPage();
        verifyDefaultField(repasswordTxt, method);
    }

    public void verifyPasswordField(String a) {


    }

    private void verifyEnteredData(By b, String a) {
        WebElement dataEntered = DriverManager.getDriver().findElement(b);
        Assert.assertTrue(dataEntered.getAttribute("Value").equalsIgnoreCase(a), "Entered data is matching");

    }

    public void verifyEnteredLastname() {
        openRegisterPage();
        WebElement lastnameE = DriverManager.getDriver().findElement(lastnameTxt);
        lastnameE.sendKeys("helloohow");
        verifyEnteredData(lastnameTxt, "helloohow");

    }


    public void verifyEnteredPasswordField(String a) {
        openRegisterPage();
        WebElement passwordE = DriverManager.getDriver().findElement(passTxt);
        passwordE.sendKeys(a);
        System.out.println("hello" + passwordE.getAttribute("textContent"));
//        verifyEnteredData(passTxt,a);
//        Assert.assertTrue(passwordE.getAttribute("Value").equalsIgnoreCase(a), "E");
    }

    public void verifyEnteredRePasswordField(String a) {
        openRegisterPage();
        WebElement repasswordE = DriverManager.getDriver().findElement(repasswordTxt);
        repasswordE.sendKeys(a);

    }

    public void enterLastname(String testdata) {
        openRegisterPage();
        WebUI.getElement(lastnameTxt).sendKeys(testdata);
        logUtils.info("in enterlastname");
        WebUI.sleep(3);
    }
}