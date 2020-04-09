package string.change;

public class StringChange {
    public static void main(String[] args) {
        String str = "Hello World";
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            builder.append((char) ((int)c ^ 32));
        }
        System.out.println(builder.toString());
    }
}
