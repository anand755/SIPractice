package b14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SubSetOFAnArray {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int testCnt = 0; testCnt < testCaseCount; testCnt++) {
            int n = sc.nextInt();


            ArrayList<Integer> arrInput = new ArrayList<>();
            //int[] arrInput = new int[n];
            for (int j = 0; j < n; j++) {
                arrInput.add(sc.nextInt());
            }
            Collections.sort(arrInput);
            //Arrays.stream(arrInput).forEach(System.out::print);
            ArrayList<Integer> al = new ArrayList<Integer>();
            sub(arrInput, al, -1, n);
        }
    }

    private static void sub(ArrayList<Integer> arrInput, ArrayList<Integer> al, int i, int n) {
        if (al.size() > 0) {
            for (Integer k : al) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        for (int j = i + 1; j < n; j++) {
            al.add(arrInput.get(j));
            sub(arrInput, al, j, n);
            al.remove(al.size() - 1);
        }
    }
}
