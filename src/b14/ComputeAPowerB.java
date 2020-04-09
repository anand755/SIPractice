package b14;

import java.io.*;
import java.util.Arrays;

public class ComputeAPowerB {
    private static int m = (int) 1E9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] ab = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int a = ab[0];
            int b = ab[1];
            long ans = computeAPowerB(a, b);
            writer.write(ans + "\n");
            writer.flush();
        }
    }

    private static long computeAPowerB(int a, int b) {

        if (b == 1) {
            return (long) a;
        }
        if (b == 0) {
            return 1L;
        }

        long temp = computeAPowerB(a, b / 2);

        long ans = ((temp % m) * (temp % m)) % m;

        if (b % 2 == 0) {
            return ans;
        } else {
            return ((ans * a) % m);
        }
    }
}
