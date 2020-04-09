package w1;

public class BitwiseOp1 {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;

        System.out.println("a = " + a + " b = " + b);

        System.out.println("a | b : " + (a | b));
        System.out.println("a & b : " + (a & b));
        System.out.println("a ^ b : " + (a ^ b));
        System.out.println("~b : " + (~b));

    }
}
