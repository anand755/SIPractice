package project.euler;

import java.io.*;

public class MultiplesOf3And5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {
            int numInput = Integer.parseInt(reader.readLine());
            long sum = getTotalSum(numInput);
            writer.write(sum + "\n");
            writer.flush();
        }
        //writer.flush();
    }

    private static long getTotalSum(int numInput) {
        long sum = 0;

        //As we are not suppose to consider last number while computing as per problem statement
        numInput = numInput - 1;

        //AP Series Sum
        int firstNum_3 = 3;
        long lastNum_3 = numInput - (numInput % 3);
        long numberOfTerms_3 = lastNum_3 / 3;
        long sumFor_3 = (numberOfTerms_3 * (firstNum_3 + lastNum_3)) / 2;

        //AP Series Sum
        int firstNum_15 = 15;
        long lastNum_15 = numInput - (numInput % 15);
        long numberOfTerms_15 = lastNum_15 / 15;
        long sumFor_15 = (numberOfTerms_15 * (firstNum_15 + lastNum_15)) / 2;

        //AP Series Sum
        int firstNum_5 = 5;
        long lastNum_5 = numInput - (numInput % 5);
        long numberOfTerms_5 = lastNum_5 / 5;
        long sumFor_5 = (numberOfTerms_5 * (firstNum_5 + lastNum_5)) / 2;

        sum = sumFor_3 + sumFor_5 - sumFor_15;

        return sum;
    }
}
