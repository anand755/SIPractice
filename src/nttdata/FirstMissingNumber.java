package nttdata;

import java.io.*;
import java.util.Arrays;

public class FirstMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int missingNumber = findMissingNumber(arrInput);
            System.out.println(missingNumber + "\n");
        }
    }

    private static int findMissingNumber(int[] arrInput) {
        int arrSize = arrInput.length;
        boolean[] presense = new boolean[arrSize + 2];

        int missing = 0;
        presense[0] = true;
        for (int i : arrInput) {
            if (i > 0 && i <= arrSize) {
                presense[i] = true;
            }
        }

        for (int i = 1; i < presense.length; i++) {
            if (!presense[i]) {
                missing = i;
                break;
            }

        }
        return missing;
    }
}
