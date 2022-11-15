package coday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class SolutionImpl implements Solution {

    @Override
    public int getLaserPower(Path path) {
        int minPower = 0;
        try {
            String anamolyStr = Files.readAllLines(path).get(0);
            int numberOfAnomalies = Integer.parseInt(anamolyStr);

            String powerOfAnamolyStr = Files.readAllLines(path).get(1);
            int[] powerOfAnomalies = Arrays.stream(powerOfAnamolyStr.split(" "))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();

            minPower = getMinPower(numberOfAnomalies, powerOfAnomalies);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return minPower;
    }

    int getMinPower(int n, int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            }
        }
        return firstMax == secondMax ? firstMax + 1 : firstMax;
    }
}
