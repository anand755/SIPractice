package contest.si2;

import java.io.*;
import java.util.Arrays;

public class RangeSumSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] NAB = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int arrLength = NAB[0];
            int minVal = NAB[1];
            int maxVal = NAB[2];

            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            //long count = getSubArrCount(arrInput, arrLength, minVal, maxVal);
            long count = getSubArrCount(arrInput, arrLength, minVal-1, maxVal+1);
            writer.write(count + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static long getSubArrCount(int[] arr, int n, int L, int R) {

        int Rcnt = countSub(arr, n, R);
        int Lcnt = countSub(arr, n, L - 1);

        return Rcnt - Lcnt;
    }

    private static int countSub(int[] arr, int n, int x) {

        int st = 0;
        int end = 0;

        int sum = 0;
        int cnt = 0;
        while (end < n) {
            sum += arr[end];
            while (st <= end && sum > x) {
                sum -= arr[st];
                st++;
            }
            cnt += (end - st + 1);
            end++;
        }

        return cnt;
    }
}
