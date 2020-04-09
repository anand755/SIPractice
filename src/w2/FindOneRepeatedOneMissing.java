package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

//Given an array of size n it contains all the element out of which one element is missing and one element is
// repeated . Find this two number
//1 5 3 6 5 4
//Repeated Number is : 2 and missing number is 5

public class FindOneRepeatedOneMissing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int minNumber = 1;
        int maxNumber = arrInput.length;

        int[] arrNatural = IntStream.rangeClosed(minNumber, maxNumber).toArray();

        int arrXor = 0;
        for (int element : arrInput) {
            //arrXor = arrXor ^ element;
            arrXor ^= element;
        }

        int naturalXor = 0;
        for (int element : arrNatural) {
            naturalXor ^= element;
        }

        int bothXor = arrXor ^ naturalXor;
        int rightMostSetBit = getRightMostSetBit(bothXor);

        int bothSetBitXor = 0;
        int bothUnSetBitXor = 0;
        for (int i = 0; i < arrInput.length; i++) {
            if (isSetBit(arrInput[i], rightMostSetBit)) {
                bothSetBitXor ^= arrInput[i];
            }
            if (isSetBit(arrNatural[i], rightMostSetBit)) {
                bothSetBitXor ^= arrNatural[i];
            }
            if (!isSetBit(arrInput[i], rightMostSetBit)) {
                bothUnSetBitXor ^= arrInput[i];
            }
            if (!isSetBit(arrNatural[i], rightMostSetBit)) {
                bothUnSetBitXor ^= arrNatural[i];
            }
        }
        int missingNumber, repeatedNumber;
        repeatedNumber = Arrays.asList(arrInput).contains(bothSetBitXor) ? bothSetBitXor : bothUnSetBitXor;
        missingNumber = bothSetBitXor ^ bothUnSetBitXor ^ repeatedNumber;

        System.out.println("Repeated Number is : " + repeatedNumber + " and missing number is " + missingNumber);

    }

    private static int getRightMostSetBit(int number) {

        for (int i = 0; i < 31; i++) {
            if (isSetBit(number, i)) {
                return i;
            }
        }

        return 31;
    }

    private static boolean isSetBit(int number, int index) {
        return ((number & (1 << index)) == (1 << index));
    }
}
