package w1;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int count = 0;

        Scanner num = new Scanner(System.in);
        System.out.println("ENter a number");
        int s = num.nextInt();
        for (int i = 2; i < s/2; i++) {
            if (s % i == 0) {
                count++;
                break;
            }
        }
        if (count == 1 || s <= 1) {
            System.out.println("Not prime");
        } else {
            System.out.println("Primne numebr");
        }
    }
}
