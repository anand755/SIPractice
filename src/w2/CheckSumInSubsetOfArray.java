package w2;

import java.util.Arrays;
import java.util.Scanner;

//Enter an array:
//5 10 -3 6 8 -5
//Enter the sum to be checked in all possible subset of array:
//105
//Sum is NOT Present in the given array
public class CheckSumInSubsetOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an array: ");
        int[] arrInput = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter the sum to be checked in all possible subset of array: ");
        int requiredSum = scanner.nextInt();


        int arrSizeN = arrInput.length;

        boolean isSumPresent = false;
        int maxPossibleSubsetCount = 1 << arrSizeN;// 2 to the power N
        for (int i = 0; i < maxPossibleSubsetCount; i++) {
            int sumOfSubset = 0;
            for (int j = 0; j < arrSizeN; j++) {
                if (checkIsSetBit(i, j)) {
                    sumOfSubset = sumOfSubset + arrInput[j];
                }
            }
            if (sumOfSubset == requiredSum) {
                isSumPresent = true;
                break;
            }
        }
        if (isSumPresent) {
            System.out.println("Sum is Present in the given array");
        } else {
            System.out.println("Sum is NOT Present in the given array");
        }


    }

    private static boolean checkIsSetBit(int number, int index) {
        return ((number & (1 << index)) == (1 << index));
    }
}
