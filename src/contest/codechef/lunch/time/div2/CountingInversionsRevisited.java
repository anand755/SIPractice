package contest.codechef.lunch.time.div2;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class CountingInversionsRevisited {

    private static BigInteger totalCount;
    //private static BigInteger totalC
    private static int copyCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] NK = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int arrSize = NK[0];
            copyCount = NK[1];
            long[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToLong(Long::parseLong).toArray();


            //totalCount = 0;
            totalCount = BigInteger.valueOf(0L);
            merge_sort(arrInput, 0, arrSize - 1);

            writer.write(totalCount.toString() + "\n");
            writer.flush();
        }
        writer.flush();
    }


    private static void merge_sort(long[] arrInput, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = (lo + hi) / 2;
        merge_sort(arrInput, lo, mid);
        merge_sort(arrInput, mid + 1, hi);

        merge_array(arrInput, lo, mid, hi);

    }

    private static void merge_array(long[] arrInput, int lo, int mid, int hi) {

        long[] tempArr = new long[hi - lo + 1];
        int p = lo;
        int q = mid + 1;
        int k = 0;

        if (lo == hi) {
            return;
        }

        while ((p <= mid) && (q <= hi)) {
            if (arrInput[p] > arrInput[q]) {
                //If arrInput[p] > arrInput[q] == true, Then all the elements from p to m is also bigger than arrInput[q]

                //totalCount = totalCount + getTotalCount(mid - p + 1, copyCount);
                totalCount = totalCount.add(BigInteger.valueOf(getTotalCount(mid - p + 1, copyCount)));

                tempArr[k] = arrInput[q];
                k++;
                q++;
            } else if (arrInput[q] > arrInput[p]) {
                //If arrInput[q] < arrInput[p] == true, Then all the elements from q to hi is also bigger than arrInput[p]
                //(k-1) because it will be repeated for (k-1) time

                //totalCount = totalCount + getTotalCount(hi - q + 1, copyCount - 1);
                totalCount = totalCount.add(BigInteger.valueOf(getTotalCount(hi - q + 1, copyCount - 1)));
                tempArr[k] = arrInput[p];
                k++;
                p++;

            } else {
                //When Both value is equal
                tempArr[k] = arrInput[p];
                k++;
                p++;

            }
        }

        //Copying the remaining element to temp array
        while (p <= mid) {
            tempArr[k++] = arrInput[p++];
        }
        while (q <= hi) {
            tempArr[k++] = arrInput[q++];
        }

        //Finally copying from tempArr to original array
        for (int i = 0; i < k; i++) {
            arrInput[lo] = tempArr[i];
            lo++;
        }
    }

    private static long getTotalCount(int i, int k) {
        //i = number of times it repeats in first array.
        // number of copies of the array

        long total = 0;


        total = i * ((k * (k + 1)) / 2);

        return total;
    }
}


