package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Config;
import utils.Constants_Vars;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    public static WebDriver getDriver() {

        if (webDriver.get() == null) {
            if(Boolean.parseBoolean(Config.get(Constants_Vars.SELENIUM_GRID_ENABLED))){
                webDriver.set(getRemoteDriver());
            }else {
                webDriver.set(createDriver());
            }
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);

        chromeOptions.addArguments("--incognito"); // 🚀 Modo incógnito para evitar alertas de seguridad

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver getRemoteDriver() {
    WebDriver remoteDriver = null;

    // Crear opciones de Chrome con prefs y args
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("profile.default_content_setting_values.notifications", 2);
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setExperimentalOption("prefs", prefs);
    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

    String urlFormat = Config.get(Constants_Vars.SELENIUM_GRID_URL_FORMAT);
    String hubHost = Config.get(Constants_Vars.SELENIUM_GRID_HUB_HOST);
    String url = String.format(urlFormat, hubHost);

    try {
        remoteDriver = new RemoteWebDriver(new URL(url), chromeOptions);
        remoteDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        remoteDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        remoteDriver.manage().window().maximize();

    } catch (MalformedURLException ex) {
        System.out.println(ex);
    }

    return remoteDriver;
    }       

    public static void cleanupDriver() {
    WebDriver driver = webDriver.get();
        if (driver != null) {
            driver.quit();
            webDriver.remove();
        }
    }

}