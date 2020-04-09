package contest.si3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RangeQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] NK = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int arrLength = NK[0];
            int arrRange = NK[1];
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> freqMap = new HashMap<>();

            prepareFreq(arrInput, arrLength, freqMap);

            int queryCount = Integer.parseInt(reader.readLine());
            while (queryCount-- > 0) {
                int[] AB = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                int A = AB[0];
                int B = AB[1];
                int count = getCountInRange(freqMap, A, B);
                writer.write(count + "\n");
                //writer.flush();
            }
        }
        writer.flush();
    }

    private static void prepareFreq(int[] arrInput, int arrLength, Map<Integer, Integer> freqMap) {
        for (int i = 0; i < arrLength; i++) {
            int freq = freqMap.getOrDefault(arrInput[i], 0);
            freqMap.put(arrInput[i], freq + 1);
        }
    }

    private static int getCountInRange(Map<Integer, Integer> freqMap, int A, int B) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            count += freqMap.getOrDefault(i, 0);
        }
        return count;
    }

}
