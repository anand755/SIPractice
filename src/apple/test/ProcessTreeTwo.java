package apple.test;


import java.io.*;

public class ProcessTreeTwo {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int processNumber = Integer.parseInt(bufferedReader.readLine().trim());

        int result = findParent(processNumber);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int findParent(int processNumber) {

        int sqrt = findSqrt(1 + 8 * processNumber);

        int parent = (sqrt - 1) / 2;

        int testVal = parent * (parent + 1) / 2;

        if (processNumber > testVal) {
            parent += 1;
        }

        return parent;

    }

    private static int findSqrt(int number) {

        if (number == 0 || number == 1)
            return number;

        int lo = 1, hi = number, ans = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (mid * mid == number)
                return (int) mid;

            if (mid * mid < number) {
                lo = (int) mid + 1;
                ans = (int) mid;
            } else
                hi = (int) mid - 1;
        }

        return ans;
    }
}
