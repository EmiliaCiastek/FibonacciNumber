import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FibonacciNumberTest {

    @DataProvider(name = "parameters")
    public static Object[][] fibonacciNumbers() {
        return new Object[][] {{0, 0}, {1, 1}, {2, 1}, {7, 13}, {16, 987}};
    }

    @Test(dataProvider = "parameters")
    public void shouldCalculateFibonacciNumberRecursively(int inputNumber, int expectedFibonacciNumber) {
        FibonacciNumber fibonacci = new FibonacciNumber();
        //System.out.println(inputNumber + " " + expectedResult);
        assertEquals(fibonacci.calculateRecursive(inputNumber),  expectedFibonacciNumber);
    }



}