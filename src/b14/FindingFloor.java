package b14;

import java.util.*;

public class FindingFloor {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in1 = new Scanner(System.in);


        int n = in1.nextInt();

        ArrayList<Integer> arrInput = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int x = in1.nextInt();
            arrInput.add(x);
        }

        int q = in1.nextInt();
        ArrayList<Integer> querySortedArr = new ArrayList<>();
        for (int j = 0; j < q; j++) {
            int x = in1.nextInt();
            querySortedArr.add(x);
        }

        ArrayList<Integer> floorArr = new ArrayList<>();
        ArrayList<Integer> queryInputArr = new ArrayList<>(querySortedArr);
        Collections.sort(arrInput);
        Collections.sort(querySortedArr);
        floor(arrInput, querySortedArr, floorArr);


        int i = 0;
        while (i < q) {
            int idx = BSR(querySortedArr, 0, q - 1, queryInputArr.get(i));
            System.out.println(floorArr.get(idx));
            i++;

        }

    }

    private static int BSR(ArrayList<Integer> a, int l, int h, int x) {
        int m = 0;
        while (l <= h) {
            m = (l + h) / 2;
            if (a.get(m) == x)
                break;
            if (a.get(m) < x)
                l = m + 1;
            else
                h = m - 1;
        }
        return m;


    }

    private static void floor(ArrayList<Integer> arrInput, ArrayList<Integer> querySortedArr, ArrayList<Integer> floorArr) {
        int p1 = 0, p2 = 0;

        while (p1 < arrInput.size() && p2 < querySortedArr.size()) {
            if (arrInput.get(p1) <= querySortedArr.get(p2)) {
                p1++;
                if (p1 >= arrInput.size())
                    floorArr.add(arrInput.get(p1 - 1));
            } else {
                p2++;
                if ((p1 - 1) >= 0) {
                    int tmp = arrInput.get(p1 - 1);
                    floorArr.add(tmp);
                } else
                    floorArr.add(Integer.MIN_VALUE);
            }
        }

        /*while (p1 < x.size() && p2 < y.size()) {
            if (x.get(p1) <= y.get(p2)) {
                p1++;
                if (p1 >= x.size())
                    cr.add(x.get(p1 - 1));
            } else {
                p2++;
                if ((p1 - 1) >= 0) {
                    int tmp = x.get(p1 - 1);
                    cr.add(tmp);
                } else
                    cr.add(Integer.MIN_VALUE);
            }
        }*/
    }
}