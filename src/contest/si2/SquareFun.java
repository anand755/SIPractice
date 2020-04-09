package contest.si2;

import java.io.*;
import java.util.Arrays;

public class SquareFun {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            long[] AB = Arrays.stream(reader.readLine().split("\\s")).mapToLong(Long::parseLong).toArray();
            long numA = AB[0];
            long numB = AB[1];

            int count = getSquareCount(numA, numB);
            writer.write(count + "\n");
            //writer.flush();
        }
        writer.flush();
    }

    private static int getSquareCount(long numA, long numB) {

        int count = (int) Math.floor(Math.sqrt(numB) - Math.ceil(Math.sqrt(numA)));

        return count + 1;
    }
}
