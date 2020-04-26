import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
            {2, 2, 4},
            {2, 3, 6},
            {3, 3, 9},
            {8, 8, 64}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
            {-2, 2},
            {2, -2},
            {-5, -5},
            {0, 10}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int expectedResult) {
    int actualResult = ExampleException.rectangleArea(a, b);
    Assert.assertEquals(actualResult, expectedResult);
  }


  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    String expectedResult = "input value is below zero!";
    try {
      int actualResult = ExampleException.rectangleArea(a, b);
    } catch (IllegalArgumentException e) {
      Assert.assertEquals(e.getMessage(), expectedResult);
    }
  }
}