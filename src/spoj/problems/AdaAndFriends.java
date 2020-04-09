package spoj.problems;

import java.io.*;
import java.util.*;

public class AdaAndFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Long> celMap = new HashMap<>();
        int[] QK = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int Q = QK[0];
        int K = QK[1];
        //Long[] expenceArr = new Long[Q];

        while (Q-- > 0) {
            String[] input = reader.readLine().split("\\s");
            String friendName = input[0];
            long expence = Long.valueOf(input[1]);
            long amount = celMap.getOrDefault(friendName, 0L);
            celMap.put(friendName, expence + amount);
        }

        Long[] expenceArr = new Long[celMap.size()];
        int i = 0;
        for (Map.Entry entry : celMap.entrySet()) {
            expenceArr[i++] = (long) entry.getValue();
        }
        Arrays.sort(expenceArr, Collections.reverseOrder());
        //Arrays.sort(expenceArr);
        int sparedVal = 0;
        for (int m = 0; (m < K) && (m < expenceArr.length); m++) {
            sparedVal += expenceArr[m];
        }

        /*while (K > 0) {
            sparedVal += expenceArr[K - 1];
            K--;
        }*/
        writer.write(sparedVal + "");
        writer.flush();
    }
}
