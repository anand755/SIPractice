package contest.si3;

import java.io.*;
import java.util.Arrays;

public class ContinuousHeightOfTree {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            printHeightOfTree(arrInput, arrLength, writer);
            //writer.flush();
        }
        writer.flush();
    }

    private static void printHeightOfTree(int[] arrInput, int arrLength, BufferedWriter writer) throws IOException {


        Node root = new Node(arrInput[0]);
        writer.write(0 + " ");
        for (int i = 1; i < arrLength; i++) {
            insertNode(root, arrInput[i]);
            int height = getTreeHeight(root);
            writer.write(height + " ");
        }
        writer.write("\n");
    }


    private static int getTreeHeight(Node rootNode) {
        if (rootNode == null) {
            return -1;
        }
        return 1 + Math.max(getTreeHeight(rootNode.left), getTreeHeight(rootNode.right));
    }


    private static Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value > root.data) {
            root.right = insertNode(root.right, value);
        }
        if (value < root.data) {
            root.left = insertNode(root.left, value);
        }
        return root;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
