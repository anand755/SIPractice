package contest.si2;

import java.io.*;
import java.util.Arrays;

public class RangeOfPrimes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());

        boolean[] primeArr = getPrimeArr();
        while (testCaseCount-- > 0) {
            int[] AB = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int numA = AB[0];
            int numB = AB[1];

            int count = getPrimeCount(primeArr, numA, numB);
            writer.write(count + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static boolean[] getPrimeArr() {
        int n = (int) 1e6 + 1;

        boolean[] prime = new boolean[n + 1];
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }

    private static int getPrimeCount(boolean[] primeArr, int a, int b) {

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (primeArr[i])
                count++;
        }

        return count;
    }
}
