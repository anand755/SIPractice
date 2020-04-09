package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoneyGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int gameCount = Integer.parseInt(reader.readLine());
        int[] gameTimeArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] gameMoneyArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int maxMoney = getMaxMoney(gameTimeArr, gameMoneyArr);
        System.out.println(maxMoney);
    }

    private static int getMaxMoney(int[] gameTimeArr, int[] gameMoneyArr) {
        return 0;
    }
}
