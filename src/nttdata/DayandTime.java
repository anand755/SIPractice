package nttdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DayandTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String[] dayAndNum = reader.readLine().trim().split("\\s");
            String day = dayAndNum[0];
            int num = Integer.parseInt(dayAndNum[1]);

            String resDay = solution(day, num);
            System.out.println(resDay + "\n");

        }
    }

    public static String solution(String S, int K) {
        // write your code in Java SE 8

        Map<Integer, String> indexDays = new HashMap<>();
        indexDays.put(0, "Mon");
        indexDays.put(1, "Tue");
        indexDays.put(2, "Wed");
        indexDays.put(3, "Thu");
        indexDays.put(4, "Fri");
        indexDays.put(5, "Sat");
        indexDays.put(6, "Sun");


        int dayCount = K % 7;

        int currIndex = getCurrIndex(S, indexDays);

        int outDayIndex = (currIndex + dayCount) % 7;
        String outDay = indexDays.get(outDayIndex);

        return outDay;
    }


    private static int getCurrIndex(String day, Map<Integer, String> indexDays) {

        for (Map.Entry<Integer, String> entry : indexDays.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(day)) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
