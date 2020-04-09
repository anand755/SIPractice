package contest.icpc2019;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwinBuildings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int landCount = Integer.parseInt(reader.readLine());

        List<int[]> landList = new ArrayList<>();

        while (landCount-- > 0) {
            int[] land = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            landList.add(land);
            int maxArea = getMaxArea(landList);
            writer.write(maxArea + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int getMaxArea(List<int[]> landList) {




        return 0;
    }
}
