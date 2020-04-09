package apple.test;

import java.io.*;
import java.util.*;


public class ThrottlingGateway {
    // Complete the droppedRequests function below.
    private static int droppedRequests(int requestTimeCount, List<Integer> requestTimeArr) {

        int dropCount = 0;
        Map<Integer, Integer> reqTimeFreqMap = new HashMap<>();

        for (int i = 0; i < requestTimeCount; i++) {
            int time = requestTimeArr.get(i);
            int freq = reqTimeFreqMap.getOrDefault(time, 0);
            reqTimeFreqMap.put(time, freq + 1);
        }


        int startTime = requestTimeArr.get(0);
        int endTime = requestTimeArr.get(requestTimeCount - 1);


        //Single second rule (max 3 request per second)

        for (Map.Entry<Integer, Integer> entry : reqTimeFreqMap.entrySet()) {
            int time = entry.getValue();
            if (time > 3) {
                int extra = time - 3;
                dropCount += extra;
                reqTimeFreqMap.put(entry.getKey(), 3);
            }
        }

        //Ten second window rule (max 20 request per 10 second)
        int winTenSum = 0;
        for (int i = startTime; i <= (startTime + 9); i++) {
            winTenSum += reqTimeFreqMap.getOrDefault(i, 0);

            if (winTenSum > 20) {
                int extra = winTenSum - 20;
                dropCount += extra;
                winTenSum = 20;
                reqTimeFreqMap.put(i, reqTimeFreqMap.get(i) - extra);

                i = i + 1;
                while (i <= (startTime + 9)) {
                    dropCount += reqTimeFreqMap.getOrDefault(i, 0);
                    reqTimeFreqMap.put(i, 0);
                    i++;
                }
                break;
            }

        }

        for (int i = startTime; i <= endTime - 9; i++) {
            int outTime = reqTimeFreqMap.getOrDefault(i, 0);
            int inTime = reqTimeFreqMap.getOrDefault((i + 10), 0);

            winTenSum = winTenSum - outTime + inTime;
            if (winTenSum > 20) {
                int extra = winTenSum - 20;
                dropCount += extra;
                winTenSum = 20;
                reqTimeFreqMap.put(i + 10, reqTimeFreqMap.get(i + 10) - extra);
            }
        }


        //Sixty second window rule (max 60 request per 60 second)

        int winSixtySum = 0;
        for (int i = startTime; i <= (startTime + 59); i++) {
            winSixtySum += reqTimeFreqMap.getOrDefault(i, 0);

            if (winSixtySum > 60) {
                int extra = winSixtySum - 60;
                dropCount += extra;
                winSixtySum = 60;
                reqTimeFreqMap.put(i, reqTimeFreqMap.get(i) - extra);

                i = i + 1;
                while (i <= (startTime + 59)) {
                    dropCount += reqTimeFreqMap.getOrDefault(i, 0);
                    reqTimeFreqMap.put(i, 0);
                    i++;
                }
                break;
            }
        }

        for (int i = startTime; i <= endTime - 59; i++) {
            int outTime = reqTimeFreqMap.getOrDefault(i, 0);
            int inTime = reqTimeFreqMap.getOrDefault((i + 60), 0);

            winSixtySum = winSixtySum - outTime + inTime;
            if (winSixtySum > 60) {
                int extra = winSixtySum - 60;
                dropCount += extra;
                winSixtySum = 60;
                reqTimeFreqMap.put(i + 60, reqTimeFreqMap.get(i + 60) - extra);
            }
        }


        return dropCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());
        //int[] requestTimeArr = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        List<Integer> reqList = new ArrayList<>();
        for (int i = 0; i < requestTimeCount; i++) {
            reqList.add(Integer.parseInt(bufferedReader.readLine()));
        }
        /*List<String> requestTimeTemp = new ArrayList<>();

        IntStream.range(0, requestTimeCount).forEach(i -> {
            try {
                requestTimeTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> requestTime = requestTimeTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());*/

        int res = droppedRequests(requestTimeCount, reqList);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
