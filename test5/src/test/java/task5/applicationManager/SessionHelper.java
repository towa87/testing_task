package task5.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {

    type(By.id("username"), username);
    type(By.id("password"), password);
    click(By.xpath("//div[7]/div[1]/div/div[3]/div[2]/div/fieldset/div/form[2]/div[2]/input"));

  }
}
