package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("/Users/ah/Documents/GitHub/java_pft/mantis-tests/src/test/resources/%s.properties",target))));


        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            String pathToGeckoDriver = Paths.get("/Users/ah/Documents/GitHub/java_pft/geckodriver").toAbsolutePath().toString();
            System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd = new SafariDriver();
        }
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        properties.getProperty("web.adminPassword");
    }

    public void stop() {
        wd.quit();
    }

    public HttpSession newSession(){
        return new HttpSession(this);
    }

    public String getProperty(String key){
       return properties.getProperty(key);
    }

}
