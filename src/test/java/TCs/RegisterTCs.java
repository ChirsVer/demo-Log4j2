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


}