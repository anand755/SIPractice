package contest.codechef.lunch.time.div2;

import java.io.*;
import java.util.Arrays;

public class KhaledInHIT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            String xyzVal = getBoundariesValue(arrLength, arrInput);
            writer.write(xyzVal + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static String getBoundariesValue(int arrLength, int[] arrInput) {

        Arrays.sort(arrInput);

        int p = arrLength / 4;
        int x = arrInput[p];
        int y = arrInput[2 * p];
        int z = arrInput[3 * p];

        int countA = 0, countB = 0, countC = 0, countD = 0;
        for (int num : arrInput) {
            if (num < x) {
                countD++;
            }
            if (num >= x && num < y) {
                countC++;
            }
            if (num >= y && num < z) {
                countB++;
            }
            if (num >= z) {
                countA++;
            }
        }
        if ((countA == countB) && (countB == countC) && (countC == countD)) {
            return (x + " " + y + " " + z);
        } else {
            return "-1";
        }
    }
}
