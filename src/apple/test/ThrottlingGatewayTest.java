package apple.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class ThrottlingGatewayTest {
    // Complete the droppedRequests function below.
    private static int droppedRequests(int requestTimeCount, int[] requestTimeArr) {

        int dropCount = 0;
        Map<Integer, Integer> reqTimeFreqMap = new HashMap<>();

        for (int i = 0; i < requestTimeCount; i++) {
            int time = requestTimeArr[i];
            int freq = reqTimeFreqMap.getOrDefault(time, 0);
            reqTimeFreqMap.put(time, freq + 1);
        }


        int startTime = requestTimeArr[0];
        int endTime = requestTimeArr[requestTimeCount - 1];


        for (int i = startTime; i <= endTime; i++) {
            int freq = reqTimeFreqMap.getOrDefault(i, 0);
            dropCount += freq > 3 ? (freq - 3) : 0;
        }

        int win_ten = startTime + 9;
        int win_ten_freq = 0;
        for (int i = startTime; i <= win_ten; i++) {
            int freq = reqTimeFreqMap.getOrDefault(i, 0);
            win_ten_freq += freq;
        }
        dropCount += (win_ten_freq > 20) ? (win_ten_freq - 20) : 0;

        //int freq = 0;
        for (int time = startTime; time <= endTime - 9; time++) {

            int outGoingTime = time;
            int inComingTime = outGoingTime + 10;

            win_ten_freq = win_ten_freq - reqTimeFreqMap.getOrDefault(outGoingTime, 0) + reqTimeFreqMap.getOrDefault(inComingTime, 0);

            dropCount += (win_ten_freq > 20) ? (win_ten_freq - 20) : 0;

        }


        int win_sixty = startTime + 59;
        int win_sixty_freq = 0;
        for (int i = startTime; i <= win_sixty; i++) {
            int freq = reqTimeFreqMap.getOrDefault(i, 0);
            win_sixty_freq += freq;
        }
        dropCount += (win_sixty_freq > 60) ? (win_sixty_freq - 60) : 0;

        //int freq = 0;
        for (int time = startTime; time <= endTime - 59; time++) {

            int outGoingTime = time;
            int inComingTime = time + 60;

            win_sixty_freq = win_sixty_freq - reqTimeFreqMap.getOrDefault(outGoingTime, 0) + reqTimeFreqMap.getOrDefault(inComingTime, 0);

            dropCount += (win_sixty_freq > 60) ? (win_sixty_freq - 60) : 0;
        }


        return dropCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());
        int[] requestTimeArr = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

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

        int res = droppedRequests(requestTimeCount, requestTimeArr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
