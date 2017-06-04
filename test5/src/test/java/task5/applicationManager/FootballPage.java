package task5.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FootballPage extends HelperBase {

  public FootballPage(WebDriver wd) {
    super(wd);
  }

  public void selectHomeBidForFootballEvent() {
    By locator = By.id("OB_OU1567566081");
    if (isElementPresent(locator)) {
//wd.findElement(locator).click();
      WebElement buttonToClick = (new WebDriverWait(wd, 30))
              .until(ExpectedConditions.presenceOfElementLocated(locator));

      buttonToClick.click();
    }


  }

  public void enterBidValue(Double bidValue)

  {
    By locator = By.id("stake-input__1580581571L");
    if (isElementPresent(locator)) {
      type(locator, Double.toString(bidValue));
    }
  }

  public void placeBid() {

    By locator = By.id("place-bet-button");
    if (isElementPresent(locator)) {
      wd.findElement(locator).click();
    }
  }

  public Double checkReturnedOffered() {
    return Double.valueOf(wd.findElement(By.id("app.useFootballPage()")).getAttribute("span"));
  }
}

