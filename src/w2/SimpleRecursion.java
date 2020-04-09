package w2;

import java.util.Scanner;

public class SimpleRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Calculate Sum of N Element. Enter N value: ");
        int numberForSum = scanner.nextInt();
        int resultNSum = sum(numberForSum);
        System.out.println("Sum of N natural number is: " + resultNSum);
        System.out.println();
        System.out.print("Calculate Factorial of N. Enter N value: ");
        int numberForFact = scanner.nextInt();
        int resultNFactorial = fact(numberForFact);
        System.out.println("Factorial of N natural number is: " + resultNFactorial);
        System.out.println();
        System.out.print("Get the Nth number of a fibonacci series. Enter N value: ");
        int numberForFibonacci = scanner.nextInt();
        int resultNthOfFibonacci = getNthFibonacci(numberForFibonacci);
        System.out.println("Nth fibonacci number is: " + resultNthOfFibonacci);
        System.out.println();
        System.out.println("Get the AP sum value. So Enter Start Number then Total Element and then Common Difference");
        int startingNumber = scanner.nextInt();
        int totalElement = scanner.nextInt();
        int commonDiff = scanner.nextInt();
        int resultAPSum = getAPSum(startingNumber, totalElement, commonDiff);
        System.out.println("Result of N AP Sum is: " + resultAPSum);
    }

    private static int getAPSum(int a, int n, int d) {
        if (n == 1) {
            return a;
        } else {
            return (a + (n - 1) * d) + getAPSum(a, n - 1, d);
        }
    }

    private static int getNthFibonacci(int numberForFibonacci) {
        if (numberForFibonacci == 1 || numberForFibonacci == 2) {
            return 1;
        } else {
            return getNthFibonacci(numberForFibonacci - 1) + getNthFibonacci(numberForFibonacci - 2);
        }
    }

    private static int fact(int numberForFact) {
        if (numberForFact == 0) {
            return 1;
        } else {
            return numberForFact * fact(numberForFact - 1);
        }
    }

    private static int sum(int numberForSum) {
        if (numberForSum == 0) {
            return 0;
        } else {
            return numberForSum + sum(numberForSum - 1);
        }
    }
}
