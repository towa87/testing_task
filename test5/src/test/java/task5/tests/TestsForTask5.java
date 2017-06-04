package task5.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import task5.applicationManager.ApplicationManager;

import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.logging.Logger;

public class TestsForTask5 extends TestBase {
  private static final Logger LOGGER = Logger.getLogger(TestsForTask5.class.getName());

  @DataProvider
  public Iterator<Object[]> valuesToCheck() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    Double bidValue = 0.05;
    Double expectedReturnedOffered = 0.08;
    List<Object> listOfInputData = Arrays.asList(bidValue, expectedReturnedOffered);
    list.add(new Object[] {listOfInputData});
    return list.iterator();
  }



  @Test(dataProvider = "valuesToCheck")
  public void searchForSpecificGameOnVegasCasinoTest(List<Double> valuesToCheck) {
    LOGGER.info("Test searchForSpecificGameOnVegasCasinoTest has started" );
    Double bidValue = valuesToCheck.get(0);
    app.goTo().footballPage();
    app.useFootballPage().selectHomeBidForFootballEvent();
    app.useFootballPage().enterBidValue(bidValue);
    app.useFootballPage().placeBid();
    app.useFootballPage().checkReturnedOffered();
    Double expectedReturnedOffered = valuesToCheck.get(1);
    Assert.assertEquals(app.useFootballPage().checkReturnedOffered(), expectedReturnedOffered);
    LOGGER.info("Test searchForSpecificGameOnVegasCasinoTest was finished" );
  }
}
