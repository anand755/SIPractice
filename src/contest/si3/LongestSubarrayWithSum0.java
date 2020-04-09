package contest.si3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSum0 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int length = getMaxLengthWithSumZero(arrInput, arrLength);
            writer.write(length + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int getMaxLengthWithSumZero(int[] arrInput, int arrLength) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int len = 0;

        for (int i = 0; i < arrLength; i++) {
            sum += arrInput[i];
            if (!map.containsKey(sum))
                map.put(sum, i);
            if (map.containsKey(sum) && len < i - map.get(sum)) {
                len = i - map.get(sum);
            }
        }
        return len;
    }
}
