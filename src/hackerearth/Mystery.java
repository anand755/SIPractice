package hackerearth;

import java.io.*;

public class Mystery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //int testCaseCount = Integer.parseInt(reader.readLine());

        String strNum;
        while (!(strNum = reader.readLine()).isEmpty()) {
            long inputNum = Long.parseLong(strNum);
            int setBitCount = getTotalSetBitCount(inputNum);
            writer.write(setBitCount + "\n");
        }
        writer.flush();

        /*while (testCaseCount-- > 0) {
            long inputNum = Long.parseLong(reader.readLine());
            int setBitCount = getTotalSetBitCount(inputNum);
            writer.write(setBitCount + "\n");
            writer.flush();
        }*/
        //writer.flush();
    }

    private static int getTotalSetBitCount(long inputNum) {
        int setBitCount = 0;
        long currNum = 0;

        for (int i = 0; i <= 63; i++) {
            if (isSetBit(inputNum, i)) {
                setBitCount++;
                currNum += (1L << i);
                if (currNum == inputNum) {
                    break;
                }
            }
        }
        return setBitCount;
    }

    private static boolean isSetBit(long number, int pos) {
        return ((number & (1L << pos)) == (1L << pos));
    }
}
