package contest.si2;

import java.io.*;

public class CheckSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String[] AB = reader.readLine().split("\\s");
            String strA = AB[0].trim();
            String strB = AB[1].trim();

            String isAllPresent = checkSubsequence(strA.toCharArray(), strB.toCharArray()) ? "Yes" : "No";
            writer.write(isAllPresent + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static boolean checkSubsequence(char[] strA, char[] strB) {

        int count = 0;

        int p = 0;
        int q = 0;

        while (p < strA.length && q < strB.length) {
            if (strA[p] == strB[q]) {
                count++;
                p++;
                q++;
            } else {
                q++;
            }
        }

        return (count == strA.length);

    }
}
