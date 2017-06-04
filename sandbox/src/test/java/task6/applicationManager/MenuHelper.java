package task6.applicationManager;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;


public class MenuHelper extends HelperBase {
  private static final Logger LOGGER = Logger.getLogger(MenuHelper.class.getName());

  public MenuHelper(WebDriver wd) {
    super(wd);
  }

  public void selectMagnifierButton() {

    if (isElementPresent(By.cssSelector("button.btn-search-magnifier.btn-search-magnifier--wrapped")))
      LOGGER.info("Magnifier button was selected");
      click(By.cssSelector("button.btn-search-magnifier.btn-search-magnifier--wrapped"));
  }


  public void searchFor(String testToSearch) {
    if (isElementPresent(By.xpath("//div[@class='search__input-wrapper']/input")))

      type(By.xpath("//div[@class='search__input-wrapper']/input"), testToSearch);

  }
}

