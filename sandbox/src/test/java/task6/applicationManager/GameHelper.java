package task6.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class GameHelper extends HelperBase {
  private static final Logger LOGGER = Logger.getLogger(GameHelper.class.getName() );
  public GameHelper(WebDriver wd) {
    super(wd);
  }

  public void select(String nameOfTheGame) {


    Actions actions = new Actions(wd);
    WebElement game = wd.findElement(By.xpath("//div[contains(text(), 'Mayfair Roulette')]"));

    actions.moveToElement(game).click().build().perform();
   new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@class='tiles-container__row']//button[.='More ']"))).build().perform();
    wd.findElement(By.xpath("//div[@class='tiles-container__row']//button[.='More ']")).click();
    LOGGER.info("Name of the game was selected");

  }

  public void play(String gameToPay) {
    WebElement playNowButton = wd.findElement(By.className("Play Now"));
    playNowButton.click();
    LOGGER.info("Play button was selected");
  }
public boolean logginScreenIsPresent() {

  if (wd.findElement(By.className("modal modal-login")).isDisplayed())
  {
    LOGGER.info("Loggin page is displyed");
    return true;
  }
  else {
    LOGGER.info("There is no a Loggin page");
    return false;}
  }

}
