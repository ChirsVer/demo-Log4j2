package keywords;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal <WebDriver> driverThreadLocal= new ThreadLocal<>();
    private DriverManager(){

    }
    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }
    public static void setDriver(WebDriver _driver){
        DriverManager.driverThreadLocal.set(_driver);

    }
    public static void quite(){
        DriverManager.driverThreadLocal.get().quit(); // tắt browser
        DriverManager.driverThreadLocal.remove(); //xóa luôn thread đó
    }
}
