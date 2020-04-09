package sortings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSortAlter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            merge_sort(arrInput, 0, (arrInput.length - 1));

            Arrays.stream(arrInput).forEach(__ -> System.out.print(__ + " "));
        }
    }

    private static void merge_sort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;           // defines the current array in 2 parts .
            merge_sort(A, start, mid);                 // sort the 1st part of array .
            merge_sort(A, mid + 1, end);              // sort the 2nd part of array.

            // merge the both parts by comparing elements of both the parts.
            merge(A, start, mid, end);
        }
    }


    private static void merge(int[] A, int start, int mid, int end) {
        //stores the starting position of both parts in temporary variables.
        int p = start, q = mid + 1;

        int[] Arr = new int[end - start + 1];
        int k = 0;

        for (int i = start; i <= end; i++) {
            if (p > mid)      //checks if first part comes to an end or not .
                Arr[k++] = A[q++];

            else if (q > end)   //checks if second part comes to an end or not
                Arr[k++] = A[p++];

            else if (A[p] < A[q])     //checks which part has smaller element.
                Arr[k++] = A[p++];

            else
                Arr[k++] = A[q++];
        }
        for (int j = 0; j < k; j++) {
   /* Now the real array has elements in sorted manner including both
        parts.*/
            A[start++] = Arr[j];
        }
    }
}
