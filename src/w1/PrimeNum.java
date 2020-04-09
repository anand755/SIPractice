package w1;

import java.util.Scanner;

public class PrimeNum {
    public static void main(String[] args) {
        int count = 0;

        Scanner num = new Scanner(System.in);
        System.out.println("ENter a number");
        int s = num.nextInt();
        for (int i = 1; i < s ; i++){
            if (s % i == 0 ){
                count++;
            }
        }
        if (count >2){
            System.out.println(" prime");
        } else {
            System.out.println(" Not Prime numebr");
        }
    }
}
