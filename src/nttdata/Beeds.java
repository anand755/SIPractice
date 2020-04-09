package nttdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beeds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int length = arrInput.length;
            int number = getLongestArr(length, arrInput);
            System.out.println(number + "\n");

        }
    }

    private static int getLongestArr(int length, int[] A) {

        boolean[] checkBool = new boolean[length];
        //Arrays.fill(checkBool, false);

        int ans = 0;
        int fi = 0;

        int firstCount = 0;
        while (fi < length) {
            if (!checkBool[fi]) {
                firstCount++;
                checkBool[fi] = true;
                fi = A[fi];

            } else {
                break;
            }
        }

        if (firstCount >= length / 2) {
            ans = firstCount;
            return ans;
        }


        int si = 0;
        for (int i = 0; i < length; i++) {
            if (!checkBool[i]) {
                si = i;
                break;
            }
        }


        int secondCount = 0;
        while (si < length) {

            if (!checkBool[si]) {
                secondCount++;
                checkBool[si] = true;
                si = A[si];
            } else {
                break;
            }
        }

        int thirdCount = length - (firstCount + secondCount);


        ans = Math.max(secondCount, thirdCount);


        return ans;
    }
}
