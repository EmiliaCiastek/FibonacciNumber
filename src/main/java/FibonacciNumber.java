public class FibonacciNumber {
    public int calculateRecursive(int inputNumber) {
        if(inputNumber == 0) {
            return 0;
        } else if(inputNumber == 1){
            return 1;
        }

        return calculateRecursive(inputNumber - 1)  + calculateRecursive(inputNumber - 2);
    }
}