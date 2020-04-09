package contest.codeforces;

import java.io.*;
import java.util.Arrays;

public class DanielAndSpringCleaning {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            long[] lr = Arrays.stream(reader.readLine().split("\\s")).mapToLong(Long::parseLong).toArray();
            long L = lr[0];
            long R = lr[1];
            long pairCount = getPairCount(L, R);
            writer.write(pairCount + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static long getPairCount(long l, long r) {

        long count = 0L;
        for (long a = l; a < r; a++) {

            for (long b = a + 1; b <= r; b++) {
                if ((a + b) == (a ^ b))
                    count++;
            }
        }

        return count;
    }
}
