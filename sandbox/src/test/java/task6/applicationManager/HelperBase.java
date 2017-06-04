package task6.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class HelperBase {
  private static final Logger LOGGER = Logger.getLogger(HelperBase.class.getName() );
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected boolean isElementPresent(By locator) {
    try{
      wd.findElement(locator);
              return true;
    }catch (NoSuchElementException ex)
    {return false;}

  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type (By locator, String text)
  {
    click(locator);
    if(text != null)
    {
     String getText = wd.findElement(locator).getAttribute("value");
    if(!text.equals(getText))
    {wd.findElement(locator).clear();
    }
      wd.findElement(locator).sendKeys(text);
    }
  }
}
