package b14;

import java.io.*;
import java.util.Arrays;

public class SumOfPairs {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] nk = reader.readLine().trim().split("\\s");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] ar = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            mergeSort(ar, 0, n - 1);

            if (sumPair(ar, k) == true)
                writer.write("True" + "\n");
            else
                writer.write("False" + "\n");

            writer.flush();
        }

    }

    static boolean sumPair(int[] ar, int k) {
        int n = ar.length;
        int p1 = 0, p2 = n - 1;
        while (p1 < n && p2 < n) {
            if (p1 == p2) {
                break;
            }
            if (ar[p1] + ar[p2] == k) {
                return true;

            }
            if (ar[p1] + ar[p2] > k)
                p2--;
            else
                p1++;
        }
        return false;
    }

    static void mergeSort(int[] ar, int l, int h) {
        if (l == h)
            return;
        int mid = ((l + h)) / 2;

        mergeSort(ar, l, mid);
        mergeSort(ar, mid + 1, h);
        merge(ar, l, h, mid);

    }

    static void merge(int[] ar, int l, int h, int m) {
        int i = l, j = m + 1, k = l;
        int[] c = new int[ar.length];
        while ((i < m + 1) && (j < h + 1)) {
            if (ar[i] < ar[j]) {
                c[k++] = ar[i++];

            } else {
                c[k++] = ar[j++];

            }
        }
        while (i < m + 1) {
            c[k++] = ar[i++];

        }
        while (j < h + 1) {
            c[k++] = ar[j++];
        }
        for (int o = l; o < h + 1; o++) {
            ar[o] = c[o];
        }

    }
}
