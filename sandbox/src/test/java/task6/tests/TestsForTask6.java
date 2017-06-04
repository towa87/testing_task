package task6.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsForTask6 extends TestBase {


  @Test()
  public void searchForSpecificGameOnVegasCasinoTest()

  {
    String gameToPay = "Mayfair Roulette";

    app.menu().selectMagnifierButton();
    app.menu().searchFor(gameToPay);
    app.game().select(gameToPay);
    app.game().play(gameToPay);
    Assert.assertTrue(app.game().logginScreenIsPresent());
  }


}
