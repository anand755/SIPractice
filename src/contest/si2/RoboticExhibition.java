package contest.si2;

import java.io.*;
import java.util.Arrays;

public class RoboticExhibition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());

            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int minRobotPower = getMinRobotPower(arrInput, arrLength);
            writer.write(minRobotPower + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int getMinRobotPower(int[] arrInput, int arrLength) {

        Arrays.sort(arrInput);
        int minReqPower = 1; // Initialize result

        for (int i = 0; i < arrLength && arrInput[i] <= minReqPower; i++)
            minReqPower = minReqPower + arrInput[i];

        return minReqPower;

    }
}
