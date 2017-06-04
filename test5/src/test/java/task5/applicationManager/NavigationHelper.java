package task5.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }


  public void footballPage() {
By locator = By.cssSelector("i.contextual-nav__icon.icon-football");
 wd.findElement(locator).click();


    }
  }

