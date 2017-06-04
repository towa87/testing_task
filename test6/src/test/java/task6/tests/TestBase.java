package task6.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import task6.applicationManager.ApplicationManager;

import java.io.IOException;

public class TestBase {

ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
    app.goTo().homePage();

  }
  @AfterSuite(alwaysRun = true)
  public void tearDown(){
    app.stop();
  }

}
