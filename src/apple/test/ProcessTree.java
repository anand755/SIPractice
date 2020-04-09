package apple.test;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProcessTree {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int processNumber = Integer.parseInt(bufferedReader.readLine().trim());

        int result = findParent(processNumber);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int findParent(int processNumber) {

        int parent = (int) (Math.sqrt(1 + 8 * processNumber) - 1) / 2;

        int testVal = parent * (parent + 1) / 2;

        if (processNumber > testVal) {
            parent += 1;
        }

        return parent;

    }
}
