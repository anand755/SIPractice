package eular;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem7Prime {
    private static int maxSize = (int) 1E8;
    private static boolean[] primeFlag = new boolean[maxSize + 1];
    private static int[] primeNum = new int[maxSize + 1];

    private static List<Integer> primeNumList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        generateAllPrime(writer);
        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int index = Integer.parseInt(reader.readLine());
            writer.write(primeNum[index - 1] + "\n");
            writer.flush();
        }
    }

    private static void generateAllPrime(BufferedWriter writer) throws IOException {
        Arrays.fill(primeFlag, true);
        primeFlag[0] = primeFlag[1] = false;

        int primeNumIndex = 0;

        for (int factor = 2; factor * factor <= maxSize; factor++) {
            if (primeFlag[factor]) {
                primeNumList.add(factor);
                primeNum[primeNumIndex++] = factor;
                for (int p = factor; factor * p <= maxSize; p++) {
                    primeFlag[factor * p] = false;
                }
            }
        }

        System.out.println("List size = " + primeNumList.size());
        System.out.println("Last Num = "+primeNumList.get(primeNumList.size()-1));
    }
}
