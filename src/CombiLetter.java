import java.io.*;

public class CombiLetter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] word = reader.readLine().trim().toCharArray();
        int length = word.length;

        int possibleWord = 1 << length;

        for (int i = 0; i < possibleWord; i++) {
            String newWord = "";
            for (int pos = 0; pos < length; pos++) {
                if (CB(i, pos)) {
                    newWord = word[pos] + newWord;
                }
            }
            //writer.write(newWord + "\n");
            printAllCombi(newWord, writer);
            writer.write("\n");
        }
        writer.flush();
    }

    private static void printAllCombi(String word, Writer writer) throws IOException {
        int n = word.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = word.charAt(i);
        printAllCombi(a, n, writer);

    }

    private static void printAllCombi(char[] a, int n, Writer writer) throws IOException {
        if (n == 1) {
            writer.write(new String(a) + "" + "\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            printAllCombi(a, n - 1, writer);
            swap(a, i, n - 1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    private static boolean CB(int num, int pos) {
        return ((num & (1 << pos)) == (1 << pos));
    }
}
