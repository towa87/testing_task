package task6.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestsForTask6 extends TestBase {

  @DataProvider
  public Iterator<Object[]> valuesToCheck() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    //set up values which should be sent to the test
    String gameToPay = "Mayfair Roulette";

    List<Object> listOfInputData = Arrays.asList(gameToPay);
    list.add(new Object[] {listOfInputData});
    return list.iterator();
  }
  @Test(dataProvider = "valuesToCheck")
  public void searchForSpecificGameOnVegasCasinoTest(String gameToPay)

  {


    app.menu().selectMagnifierButton();
    app.menu().searchFor(gameToPay);
    app.game().select(gameToPay);
    app.game().play(gameToPay);

    Assert.assertTrue(app.game().logginScreenIsPresent());
  }


}
