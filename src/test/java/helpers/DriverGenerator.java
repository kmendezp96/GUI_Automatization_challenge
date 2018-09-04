package helpers;
import jnr.posix.util.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
public class DriverGenerator {
    public static final String USERNAME = "kmendezp96";
    public static final String ACCESS_KEY = "45a90bfe-eeec-42d8-8b87-36f77f2e89fa";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    public static WebDriver driver;
    public static WebDriver generateDriver(){
        if (driver==null) {
            try{
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "58.0");
                driver = new RemoteWebDriver(new URL(URL), caps);
            }
            catch(MalformedURLException exception){
                System.out.println("wrong url");
            }
            return null;
        }
        return driver;

    }
}
