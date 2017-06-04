package task6.applicationManager;

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
import java.util.logging.Logger;


public class ApplicationManager {


  private final Properties properties;
  private String browser;

  WebDriver wd;

  private GameHelper gameHelper;
  private MenuHelper menuHelper;
  private static final Logger LOGGER = Logger.getLogger( ApplicationManager.class.getName() );
  public ApplicationManager(String browser) {

    properties = new Properties();
    this.browser = browser;

  }

  public void init() throws IOException {

    String target = System.getProperty("target", "prod");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    LOGGER.info("property file was uploaded");

    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
      LOGGER.info("Firefox was selected");
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
      LOGGER.info("Chrome was selected");
    }
    if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
      LOGGER.info("IE was selected");
    }
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseURL"));
    LOGGER.info("URL was selected");

    gameHelper = new GameHelper(wd);
    menuHelper = new MenuHelper(wd);

//      sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }


  public void stop() {
    wd.quit();
  }



  public MenuHelper menu() {
    return menuHelper;
  }
  public GameHelper game(){return gameHelper;}
  }


