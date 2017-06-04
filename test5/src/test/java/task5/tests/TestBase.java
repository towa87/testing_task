package task5.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import task5.applicationManager.ApplicationManager;

import java.io.IOException;

  public class TestBase {

    ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws IOException {
      app.init();


    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
      app.stop();
    }

  }


