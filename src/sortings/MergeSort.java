package sortings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());
            int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            //int
            mergeSort(arr, 0, arrLength-1);
            Arrays.stream(arr).forEach(__ -> System.out.println(__ + " "));
        }
    }

    private static void mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            return;
        }

        int mid = (lo + hi) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {

        int[] tempArr = new int[hi - lo + 1];
        int p1 = lo, p2 = mid + 1, k = 0;

        while ((p1 <= mid) && (p2 <= hi)) {
            if (arr[p1] < arr[p2]) {
                tempArr[k] = arr[p1];
                k++;
                p1++;
            } else {
                tempArr[k] = arr[p2];
                k++;
                p2++;
            }
        }
        while (p1 <= mid) {
            tempArr[k] = arr[p1];
            k++;
            p1++;
        }
        while (p2 <= hi) {
            tempArr[k] = arr[p2];
            k++;
            p2++;
        }
        for (int i = 0; i < k; i++) {
            arr[lo] = tempArr[i];
            lo++;
        }

        /*while (p1 <= mid && p2 <= hi) {
            if (arr[p1] < arr[p2]) {
                tempArr[k++] = arr[p1++];
            } else {
                tempArr[k++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            tempArr[k++] = arr[p1++];
        }
        while (p2 <= hi) {
            tempArr[k++] = arr[p2++];
        }
        for (int i = lo; i <= hi; i++) {
            arr[i] = tempArr[i - lo];
        }*/
    }
}
