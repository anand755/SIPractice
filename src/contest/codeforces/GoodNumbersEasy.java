package contest.codeforces;

import java.io.*;

public class GoodNumbersEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int queryCount = Integer.parseInt(reader.readLine());
        while (queryCount-- > 0) {
            int number = Integer.parseInt(reader.readLine());

            int ans = getGoodNumber(number);
            writer.write(ans + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int getGoodNumber(int number) {

        int ceil = (int) Math.ceil(Math.cbrt(number));
        System.out.println("ceil " + ceil);


        return ceil;
    }
}
