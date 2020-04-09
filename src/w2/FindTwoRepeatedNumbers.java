package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

//Sample Input of the program : 5 8 2 1 5 3 6 6 4 7
// an array of size n and value from 1 to n-2. where any two numbers repeats
public class FindTwoRepeatedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int minNumber = Arrays.stream(arrInput).min().getAsInt();//1
        int maxNumber = Arrays.stream(arrInput).max().getAsInt();//N-2

        int arrXor = 0;
        for (int element : arrInput) {
            arrXor = arrXor ^ element;
        }

        int[] arrNatural = IntStream.range(minNumber, maxNumber + 1).toArray();
        int naturalXor = 0;
        for (int element : arrNatural) {
            naturalXor = naturalXor ^ element;
        }

        //Do XOR of this two result nd check which is set
        int bothXor = arrXor ^ naturalXor;
        int rightMostSetBitIndex = getSetBitIndex(bothXor);

        int xorForSetBitArr = 0;
        int xorForUnSetBitArr = 0;

        for (int element : arrInput) {
            if (checkBit(element, rightMostSetBitIndex)) {
                //setBitListForArr.add(arrInput[i]);
                xorForSetBitArr = xorForSetBitArr ^ element;
            } else {
                //unSetBitListForArr.add(arrInput[i]);
                xorForUnSetBitArr = xorForUnSetBitArr ^ element;
            }
        }

        int xorForSetBitNatural = 0;
        int xorForUnSetBitNatural = 0;
        for (int element : arrNatural) {
            if (checkBit(element, rightMostSetBitIndex)) {
                xorForSetBitNatural = xorForSetBitNatural ^ element;
            } else {
                xorForUnSetBitNatural = xorForUnSetBitNatural ^ element;
            }
        }
        int repeatedNumberOne = xorForSetBitArr ^ xorForSetBitNatural;
        int repeatedNumberTwo = xorForUnSetBitArr ^ xorForUnSetBitNatural;
        System.out.println("Repeated numbers are " + repeatedNumberOne + " and " + repeatedNumberTwo);

    }

    private static int getSetBitIndex(int number) {

        for (int i = 0; i < 31; i++) {
            if (checkBit(number, i)) {
                return i;
            }
        }
        return 31;
    }

    private static boolean checkBit(int number, int index) {
        return ((number & (1 << index)) == (1 << index));
    }
}
