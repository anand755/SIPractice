package monitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepeatAndMissinNUmber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        /*ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }*/
        ArrayList<Integer> a = (ArrayList<Integer>) Stream.of(sc.nextLine().split(",")).map(String::trim).map(Integer::valueOf).collect(Collectors.toList());

        //Collections.sort(a);
        a.forEach(__ -> System.out.print(__ + " "));

        int rep = -1;
        long actSum = (a.size() * (a.size() + 1)) / 2;
        long sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
        }
        for (int i = 0; i < a.size(); i++) {
            // sum += (long)Math.abs(a.get(i));
            int cur = Math.abs(a.get(i));
            // sum +=cur;
            if (a.get(cur - 1) < 0) {
                rep = cur;
            } else {
                int t = a.get(cur - 1);
                a.set(cur - 1, (-1 * t));
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(rep);
        res.add(((int) (actSum - sum) + rep));
        System.out.println(res);
//        return res;
    }
}
