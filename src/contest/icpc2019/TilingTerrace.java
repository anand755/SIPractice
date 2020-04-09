package contest.icpc2019;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class TilingTerrace {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NQ = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int memoryLength = NQ[0];
        int queryLength = NQ[1];

        char[] memoryArr = reader.readLine().trim().toCharArray();

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] N_K_G1_G2_G3 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int charLength = N_K_G1_G2_G3[0];
            int type1Max = N_K_G1_G2_G3[1];
            int type1Power = N_K_G1_G2_G3[2];
            int type2Power = N_K_G1_G2_G3[3];
            int type3Power = N_K_G1_G2_G3[4];

            char[] charInput = reader.readLine().trim().toCharArray();

            int maxRepelPower = getMaxRepelPower(charInput, charLength, type1Power, type2Power, type3Power);
            writer.write(maxRepelPower + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int getMaxRepelPower(char[] charInput, int charLength, int type1Power, int type2Power, int type3Power) {

        int hiPower, midPower, loPower;
        String hiPattern, midPattern, loPattern;


        //Setting lo, mid and hi power and their pattern
        hiPower = Math.max(Math.max(type1Power, type2Power), type3Power);
        if (hiPower == type1Power) {
            hiPattern = ".";

            midPower = Math.max(type2Power, type3Power);
            midPattern = (midPower == type2Power) ? ".." : ".#.";

            loPower = (midPower == type2Power) ? type3Power : type2Power;
            loPattern = (midPower == type2Power) ? ".#." : "..";
        }

        if (hiPower == type2Power) {
            hiPattern = "..";
            midPower = Math.max(type3Power, type1Power);
            midPattern = (midPower == type3Power) ? ".#." : ".";

            loPower = (midPower == type3Power) ? type1Power : type3Power;
            loPattern = (midPower == type3Power) ? "." : ".#.";
        }

        if (hiPower == type3Power) {
            hiPattern = ".#.";
            midPower = Math.max(type1Power, type2Power);
            midPattern = (midPower == type1Power) ? "." : "..";

            loPower = (midPower == type1Power) ? type2Power : type1Power;
            loPattern = (midPower == type1Power) ? ".." : ".";
        }




        return 0;
    }
}
