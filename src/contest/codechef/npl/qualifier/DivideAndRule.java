package contest.codechef.npl.qualifier;

import java.io.*;
import java.math.BigInteger;

public class DivideAndRule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            long numStudents = Long.parseLong(reader.readLine());


            String evenOddCount = getEvenAndOddCount(numStudents);

            writer.write(evenOddCount + "\n");
        }
        writer.flush();
    }

    private static String getEvenAndOddCount(long numStudents) {

        int M = (int) 1e9 + 7;

        long totalCount = 1L;
        for (int j = 1; j <= numStudents; j++) {

            totalCount = (totalCount * 2) % M;

        }

        long oddCount = totalCount / 2;
        long evenCount = oddCount - 1;

        return (evenCount + " " + oddCount);

    }
}