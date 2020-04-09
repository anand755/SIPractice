package bosch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int arrLength = Integer.parseInt(br.readLine().trim());

        int[] arrInput = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();


        long out_ = SimilarElementsPairs(arrInput);
        wr.write(out_ + "");


        wr.flush();
        wr.close();
        br.close();
    }

    static long SimilarElementsPairs(int[] arr) {
        long count = 0L;
        //Arrays.sort(arr);
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i : arr) {
            int freq = freqMap.getOrDefault(i, 0);
            freqMap.put(i, freq + 1);
        }

        int arrDistLength = freqMap.size();
        int[] arrDist = new int[arrDistLength];
        int idx = 0;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            arrDist[idx++] = entry.getKey();
        }
        Arrays.sort(arrDist);


        for (int i = 0; i < arrDistLength - 1; i++) {
            if (arrDist[i] + 1 == arrDist[i + 1]) {
                count = count + (freqMap.get(arrDist[i]) * freqMap.get(arrDist[i + 1]));
                count = count + getCombCount(freqMap.get(arrDist[i]));
                count = count + getCombCount(freqMap.get(arrDist[i + 1]));
            }
        }

        for (int i = 0; i < arrDistLength - 2; i++) {
            if (arrDist[i] + 2 == arrDist[i + 2]) {
                count = count + (freqMap.get(arrDist[i]) * freqMap.get(arrDist[i + 2]));
                count = count + getCombCount(freqMap.get(arrDist[i]));
                count = count + getCombCount(freqMap.get(arrDist[i + 2]));
            }
        }


        return count;
    }


    private static long getCombCount(int n) {

        return ((long) n * ((long) n - 1L)) / 2L;
    }
}
