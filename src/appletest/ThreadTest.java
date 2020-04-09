package appletest;

import java.util.Arrays;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        //thread1.start();
        //thread2.start();

        boolean isThread1Running = true;
        boolean isThread2Running = true;

        int odd = 1;
        int even = 2;

        thread1.run();
        thread2.run();

        int[] arr = new int[4];
        arr[0]=3;
        arr[1]=8;
        arr[2]=1;
        arr[3]=9;

        Arrays.sort(arr);


        //-1 -1 -1 7 3 3 2 2

        //countArr Size= 7

        //in the given arr if  differnece between max and min no >10E6

        //[0] = 3
        //[6] = 1
        //[2] = 2
        //[1] = 2

        //arr = 1, 1000, 10000







        //

        //while (thread1. && thread2.isAlive());

    }
}

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}