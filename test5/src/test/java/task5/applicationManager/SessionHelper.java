package task5.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    click(By.xpath("//a[@id='accountTabButton']/span[2]/span"));
    type(By.id("loginUsernameInput"), username);
    type(By.id("loginPasswordInput"), password);
    click(By.id("loginButton"));

  }
}
