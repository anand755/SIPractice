package stack.and.queue;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int arrSize = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int[] smallerElement = getNextSmallerElement(arrInput, arrSize);
            Arrays.stream(smallerElement).forEach(__ -> System.out.print(__ + " "));
            System.out.println();
        }
    }

    private static int[] getNextSmallerElement(int[] arrInput, int arrSize) {
        Stack<Integer> stack = new Stack<>();
        int[] arrOutput = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
            } else {

                while ((!stack.isEmpty()) && (arrInput[stack.peek()] > arrInput[i])) {
                    arrOutput[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            arrOutput[stack.pop()] = -1;
        }

        return arrOutput;
    }
}
