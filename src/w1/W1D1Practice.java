package w1;

public class W1D1Practice {
    public static void main(String[] args) {
        int a = 25;
        int b = 13;

        int AorB = a | b;
        int AandB = a & b;
        int AxorB = a ^ b;
        int Anot = ~a;

        System.out.println("a = " + a + " b is = " + b);

        System.out.println("a | b is " + AorB);
        System.out.println("a & b is " + AandB);
        System.out.println("a ^ b is " + AxorB);
        System.out.println("~a is " + Anot);

        System.out.println(" 1 << 3 is " + (1 << 3));


        boolean res = a <= 0 || b >= 8;

    }
}
