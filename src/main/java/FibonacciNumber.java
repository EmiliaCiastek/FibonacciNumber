import java.util.stream.Stream;

public class FibonacciNumber {
    // for "negafibonacci" {-8, -21}, {-1, 1}: F(-n) = (-1) ^(n+1) * F(n)

    public int calculateRecursive(int inputNumber) {
        if(inputNumber < 0){
            return (int) (Math.pow((-1), inputNumber + 1) * calculateRecursive(-1 * inputNumber));
        } else if(inputNumber < 2) {
            return inputNumber;
        }

        return calculateRecursive(inputNumber - 1)  + calculateRecursive(inputNumber - 2);
    }

    public int calculateIterative(int inputNumber) {
        if(inputNumber < 2) {
            return inputNumber;
        }

        int fibonacciOfZero = 0;
        int fibonacciOfOne = 1;
        int tmp;
        for (int i=inputNumber ; i>2 ; i--) {
            tmp = fibonacciOfZero;
            fibonacciOfZero = fibonacciOfOne;
            fibonacciOfOne = fibonacciOfOne + tmp;
        }
        return fibonacciOfZero + fibonacciOfOne;
    }

    public int calculateStreams(int inputNumber) {

        return  Stream.iterate(new int[]{ 0, 1 }, fib->new int[]{fib[1], fib[0]+fib[1]})
                .limit(inputNumber)
                .mapToInt(n -> n[1])
                .reduce((a, b) -> b)
                .orElse(0);
    }
}