package contest.si2;

import java.io.*;

public class ConvertingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String[] AB = reader.readLine().split("\\s");
            String strA = AB[0].trim();
            String strB = AB[1].trim();

            int number = getRemoveCharCount(strA.toCharArray(), strB.toCharArray());
            writer.write(number + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int getRemoveCharCount(char[] strA, char[] strB) {
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        /*for (int i = 0; i < 26; i++) {
            freqA[i] = 0;
            freqB[i] = 0;
        }*/

        for (char a : strA) {
            freqA[a - 'a'] = freqA[a - 'a'] + 1;
        }

        for (char b : strB) {
            freqB[b - 'a'] = freqB[b - 'a'] + 1;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            count += Math.abs(freqB[i] - freqA[i]);
        }

        return count;
    }
}
