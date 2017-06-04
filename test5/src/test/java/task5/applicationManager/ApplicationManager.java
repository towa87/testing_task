package task5.applicationManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {


  private final Properties properties;
  private String browser;

  WebDriver wd;

  private NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  private  FootballPage footballPage;


  public ApplicationManager(String browser) {
    properties = new Properties();
    this.browser = browser;

  }

  public void init() throws IOException {

    String target = System.getProperty("target", "prod");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    }
    if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseURL"));
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
   footballPage = new FootballPage(wd);

    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }


  public void stop() {
    wd.quit();
  }


  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public  FootballPage useFootballPage(){return  footballPage;}
}


