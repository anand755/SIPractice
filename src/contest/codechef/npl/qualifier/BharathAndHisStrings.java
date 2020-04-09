package contest.codechef.npl.qualifier;

import java.io.*;
import java.util.HashSet;
import java.lang.Integer;

public class BharathAndHisStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String string = reader.readLine().trim();

            String unique = getUniqueString(string);
            writer.write(unique + "\n");
        }
        writer.flush();
    }

    private static String getUniqueString(String string) {
        HashSet<Character> charSet = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (!charSet.contains(ch)) {
                charSet.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
