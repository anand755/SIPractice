package recursion;

import java.io.*;

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {

            String[] nk = reader.readLine().split("\\s");
            String n = nk[0];
            int k = Integer.parseInt(nk[1]);

            int result = superDigit(n, k);
            writer.write(result + "\n");
            writer.flush();
        }
    }

    private static int superDigit(String n, int k) {

        int sd = getSuperDigit(n);
        int sdk = sd * k;
        return getSuperDigit(sdk + "");
    }

    private static int getSuperDigit(String strNum) {
        if (strNum.length() == 1) {
            return Integer.parseInt(strNum);
        }

        int sum = 0;
        for (char ch : strNum.toCharArray()) {
            sum += Integer.parseInt(ch + "");
        }
        return getSuperDigit(sum + "");
    }
}
