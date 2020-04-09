package contest.codechef.npl.qualifier;

import java.io.*;
import java.util.*;

public class Amplification {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int amplifierCount = Integer.parseInt(reader.readLine());
            int signalVal = Integer.parseInt(reader.readLine());
            Map<Integer, List<Integer>> pairMap = new TreeMap<>();

            while (amplifierCount-- > 0) {
                int[] pair = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                int a = pair[0];
                int b = pair[1];
                List<Integer> bList = pairMap.getOrDefault(a, new ArrayList<>());
                bList.add(b);
                pairMap.put(a, bList);
            }

            long maxVoltage = getMaxVolatge(pairMap, signalVal);
            writer.write(maxVoltage + "\n");
        }
        writer.flush();

    }

    private static long getMaxVolatge(Map<Integer, List<Integer>> pairMap, int signalVal) {

        int outPutVolt = signalVal;

        for (Map.Entry<Integer, List<Integer>> entry : pairMap.entrySet()) {
            int a = entry.getKey();
            List<Integer> bList = entry.getValue();
            Collections.sort(bList);
            for (int b : bList) {
                outPutVolt = outPutVolt * a + b;
            }
        }

        return outPutVolt;
    }
}
