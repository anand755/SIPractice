package contest.icpc2019;

import java.io.*;
import java.util.Arrays;

public class AdditionRobot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NQ = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int memoryLength = NQ[0];
        int queryLength = NQ[1];

        char[] memoryArr = reader.readLine().trim().toCharArray();

        while (queryLength-- > 0) {
            long[] query = Arrays.stream(reader.readLine().split("\\s")).mapToLong(Long::parseLong).toArray();
            if (query[0] == 1) {

                int L = (int) query[1];
                int R = (int) query[2];
                //Swapping
                for (int i = (L - 1); i <= (R - 1); i++) {
                    memoryArr[i] = (memoryArr[i] == 'A') ? 'B' : 'A';
                }


            } else {
                long L = query[1];
                long R = query[2];
                long A = query[3];
                long B = query[4];
                addRobotsMemory(memoryArr, L, R, A, B, writer);
            }
        }
        writer.flush();
    }

    private static void addRobotsMemory(char[] memoryArr, long l, long r, long a, long b, BufferedWriter writer) throws IOException {
        int M = (int) 1e9 + 7;
        long outA = a;
        long outB = b;
        for (int i = (int) (l - 1); i <= (r - 1); i++) {
            if (memoryArr[i] == 'A') {
                outA = (outA + outB) % M;
            } else {
                outB = (outA + outB) % M;
            }
        }

        writer.write(outA + " " + outB + "\n");
    }
}