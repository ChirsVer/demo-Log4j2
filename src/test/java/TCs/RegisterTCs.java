package TCs;

import Listenter.TestListener;
import Logs.logUtils;
import Page.RegisterPage;
import Provider.DataProviderExcel;
import common.BaseTest;
import keywords.DriverManager;
import keywords.WebUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Helpers.CaptureHelper;

import java.lang.reflect.Method;
import java.util.Hashtable;


@Listeners(TestListener.class)
public class RegisterTCs extends BaseTest {
    RegisterPage r;


    @Test(groups = "UI")
    public void verifyHeaderTC(Method method) {
        logUtils.info("helo");
        logUtils.error("error");
        logUtils.warn("warn");
        ;
        logUtils.fatal("fatal");
        CaptureHelper.startRecord(method.getName());
        r = new RegisterPage();
        r.openRegisterPage();
        r.verifyHeaderRegisterPage();


    }

    @Test(groups = "UI")
    public void verifyDefaultFiledsTC() {
        r = new RegisterPage();
        r.openRegisterPage();
        r.verifyDefaultFields();
    }


    @Test(groups = "UI")
    public void veirfyMandatoryFieldsTC() {

        r = new RegisterPage();
        r.openRegisterPage();
        r.verifyMandotoryFields();
    }

    @Test(groups = "UIFristname")
    public void verifyPlaceHolderFirstnameTC() {

        r = new RegisterPage();
        r.openRegisterPage();
        r.verifyPlaceHolderFirstname();
    }


    //    @Test(groups = "UILastname")
//    public void verifyPlaceHolderLastnameTC() {
//
//        r = new RegisterPage ();
//        r.openRegisterPage();
//        r.verifyPlaceHolderLastname();
//    }

    @Test
    public void verifyEnteredDataTC() {
        r = new RegisterPage();
        r.openRegisterPage();
//        r.verifyEnteredData();
    }

    @Test(groups = "UI")
    public void verifyGenderCheckboxDefaultTC() {
        r = new RegisterPage();
        r.openRegisterPage();
        r.verifyGenderCheckboxDefauilt();
        WebUI.sleep(2);
    }

    @Test(dataProvider = "gender", dataProviderClass = DataProviderExcel.class)
    public void verifyGender(String gender) {
        CaptureHelper.startRecord("verifyGender");
        r = new RegisterPage();
        r.EnteredData(gender);

    }


    @Test(dataProvider = "language", dataProviderClass = DataProviderExcel.class)
    public void verifyLanguageMultiSelectTC(String a, String b) {
        r = new RegisterPage();
        r.verifyLanguageMutliSelect(a, b);
    }

    @Test(dataProvider = "register", dataProviderClass = DataProviderExcel.class)
    public void test(String first_name, String last_name, String address, String email_address, String phone, String gender, String hobby, String language, String skill, String country, String dof, String password, String repassword
    ) {
        r = new RegisterPage();
        r.openRegisterPage();
//        r.verifyEnteredData();
    }

    @Test(groups = "UI")
    public void verifySkillsDefaultTC() {
        r = new RegisterPage();
        r.verifyDefaultSkills();
//        WebUI.sleep(3);
    }

    @Test(dataProvider = "skills", dataProviderClass = DataProviderExcel.class)
    public void verifySkillsTC(String a) {
        r = new RegisterPage();
//        r.verifySkillsDropdowlList();
        r.verifySkillsDropdowlList(a);


    }

    @Test(groups = "UI")
    public void verifyDefaultDateTC() {
        r = new RegisterPage();
        r.verifyDefaultDate();
    }

    @Test(dataProvider = "date", dataProviderClass = DataProviderExcel.class)
    public void verifyDateTC(String m, String d, String y) {
        r = new RegisterPage();
        r.verifyDate(m, d, y);
    }


    @Test(dataProvider = "register", dataProviderClass = DataProviderExcel.class)

    public void testtest(String first_name, String last_name, String address, String email_address, String phone) {
        r = new RegisterPage();
        r.openRegisterPage();
        r.veirfyEnteredData(first_name, last_name, address, email_address, phone);
        WebUI.sleep(5);
    }

    @Test
    public void testLocator() {
        r = new RegisterPage();
        r.openRegisterPage();
        r.testLocator();
        WebUI.sleep(2);
    }

    @Test(groups = "UI")
    public void veirfyDefaultPassworldFiledTC(Method m) {
        r = new RegisterPage();
        r.verifyDefaultPasswordFiled(m);
    }

    @Test(groups = "UI")
    public void veifyDefaultRePasswordFieldTC(Method m) {
        r = new RegisterPage();
        r.verifyDefaultRePasswordFiled(m);
    }

    @Test
    public void t(Method m) {
        r = new RegisterPage();
        r.verifyDefaultPasswordFiled(m);

    }

    @Test
    public void veirfyDefaultCountry() {
        r = new RegisterPage();
        r.verifyDefaultCountry();
    }

    @Test(dataProvider = "country", dataProviderClass = DataProviderExcel.class)
    public void verifyCountryTC(String a) {
        r = new RegisterPage();
        r.verifyCountryDroplist(a);

    }

    @Test(dataProvider = "search-country", dataProviderClass = DataProviderExcel.class)
    public void searchCountry(String a) {
        r = new RegisterPage();
        r.verifySearchCountry(a);

    }

    @Test(groups = "Password", dataProvider = "password", dataProviderClass = DataProviderExcel.class)
    public void verifyEnteredPasswordFieldTC(String a) {
        r = new RegisterPage();
        r.verifyEnteredPasswordField(a);

    }

    @Test(groups = "Password", dataProvider = "repassword", dataProviderClass = DataProviderExcel.class)
    public void verifyEnteredRePasswordFieldTC(String a) {
        r = new RegisterPage();
        r.verifyEnteredRePasswordField(a);

    }

    @Test(dataProvider = "lastname")
    public void tt() {
        r = new RegisterPage();
        r.verifyEnteredLastname();
    }

    @Test(priority = 1, dataProvider = "lastname", dataProviderClass = DataProviderExcel.class)
    public void testLoginFromDataProviderExcelHashtable(Hashtable<String, String> data) {
        r = new RegisterPage();
        r.enterLastname(data.get("data"));
    }

    @Test
    public void trrtt() {
        r = new RegisterPage();
        r.enterLastname("hello");
        logUtils.info("info");
        logUtils.info("infotObjec");
        logUtils.warn("warn");
        logUtils.fatal("fatal");
        logUtils.error("error");
        WebUI.sleep(4);
    }

}