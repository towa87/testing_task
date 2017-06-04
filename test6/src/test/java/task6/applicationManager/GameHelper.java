package task6.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GameHelper extends HelperBase {
  public GameHelper(WebDriver wd) {
    super(wd);
  }

  public void select(String nameOfTheGame) {


    Actions actions = new Actions(wd);
    WebElement game = null;
    if (nameOfTheGame.equals("Mayfair Roulette")) {
      game = wd.findElement(By.xpath("//div[contains(text(), 'Mayfair Roulette')]"));}
              // wd.findElement(By.cssSelector("div.tile__image-gradient"));}

  actions.moveToElement(game);
   // WebElement moreButton = game.findElement(By.xpath("//../../..//button[contains(@class, 'o-btn--more')]"));
    //wd.findElement(By.xpath("//div[@class='tiles-container__row']//button[.='More ']"));

    WebElement moreButton = (new WebDriverWait(wd, 30))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//../../..//button[contains(@class, 'o-btn--more')]")));
    actions.moveToElement(moreButton);
    actions.click().build().perform();


    //div[@class='tiles-container__row']//button[.='More ']
  }

  public void play(String gameToPay) {
    WebElement playNowButton = wd.findElement(By.className("Play Now"));
    playNowButton.click();
  }
}
