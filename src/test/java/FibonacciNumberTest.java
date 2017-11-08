import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FibonacciNumberTest {
    FibonacciNumber fibonacci;
    @BeforeMethod
    public void setUp(){
        fibonacci = new FibonacciNumber();
    }

    @DataProvider(name = "parameters")
    public static Object[][] fibonacciNumbers() {
        return new Object[][] {{0, 0}, {1, 1}, {2, 1}, {7, 13}, {16, 987}};
    }

    @DataProvider(name = "negatives")
    public static Object[][] negativeFibonacciNumbers() {
        return new Object[][] {{-8, -21}, {-1, 1}, {-6, -8}, {-4, -3}};
    }

    @Test(dataProvider = "parameters")
    public void shouldCalculateFibonacciNumberRecursively(int inputNumber, int expectedFibonacciNumber) {
        assertEquals(fibonacci.calculateRecursive(inputNumber),  expectedFibonacciNumber);
    }

    @Test(dataProvider = "parameters")
    public void shouldCalculateFibonacciNumberIteratively(int inputNumber, int expectedFibonacciNumber) {
        assertEquals(fibonacci.calculateIterative(inputNumber),  expectedFibonacciNumber);
    }

    @Test(dataProvider = "parameters")
    public void shouldCalculateFibonacciNumberUsingStreams(int inputNumber, int expectedFibonacciNumber) {
        assertEquals(fibonacci.calculateStreams(inputNumber),  expectedFibonacciNumber);
    }

    @Test(dataProvider = "negatives")
    public void shouldCalculateNegativeFibonacciNumberRecursively(int inputNumber, int expectedFibonacciNumber) {
        assertEquals(fibonacci.calculateRecursive(inputNumber),  expectedFibonacciNumber);
    }
}