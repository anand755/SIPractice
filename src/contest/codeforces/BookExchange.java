package contest.codeforces;

import java.io.*;
import java.util.Arrays;

public class BookExchange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int queryCount = Integer.parseInt(reader.readLine());
        while (queryCount-- > 0) {
            int length = Integer.parseInt(reader.readLine());
            int[] books = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            processBook(books, writer);
            writer.write("\n");
        }
        writer.flush();


    }

    private static void processBook(int[] books, BufferedWriter writer) throws IOException {
        int[] arr = new int[books.length];
        int c = 0;
        for (int book : books) {
            arr[c++] = book - 1;
        }

        for (int b = 0; b < books.length; b++) {
            int index = arr[b];
            int count = 1;
            if (index == b) {
                writer.write(1 + " ");
            } else {
                while (b != arr[index]) {
                    count++;
                    index = arr[index];
                }
                writer.write(count + 1 + " ");
            }
        }
    }
}
