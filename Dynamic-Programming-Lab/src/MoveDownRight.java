import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveDownRight {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[][] sums;

    static int[][] elements;

    public static void main(String[] args) throws IOException {

        initElements();

        calculateSums();

        List<String> path = recoverPath();

        System.out.println(String.join(" ", path));
    }

    private static List<String> recoverPath() {

        List<String> path = new ArrayList<>();

        int row = elements.length - 1;
        int col = elements.length - 1;

        path.add(formatPosition(row, col));

        while (row > 0 || col > 0) {

            int top = -1;

            if (row > 0) {
                top = sums[row - 1][col];
            }

            int left = -1;

            if (col > 0) {
                left = sums[row][col - 1];
            }

            if (top > left) {
                path.add(formatPosition(row - 1, col));
                row--;
            } else {
                path.add(formatPosition(row, col - 1));
                col--;
            }
        }

        Collections.reverse(path);

        return path;
    }

    private static String formatPosition(int row, int col) {
        return String.format("[%d, %d]", row, col);
    }

    private static void calculateSums() {

        sums[0][0] = elements[0][0];

        for (int row = 1; row < sums.length; row++) {
            sums[row][0] = sums[row - 1][0] + elements[row][0];
        }

        for (int col = 1; col < sums.length; col++) {
            sums[0][col] = sums[0][col - 1] + elements[0][col];
        }

        for (int row = 1; row < sums.length; row++) {
            for (int col = 1; col < sums.length; col++) {
                sums[row][col] = Math.max(sums[row - 1][col] + elements[row][col], sums[row][col - 1] + elements[row][col]);
            }
        }
    }

    private static void initElements() throws IOException {

        int rows = Integer.parseInt(reader.readLine());

        int cols = Integer.parseInt(reader.readLine());

        elements = new int[rows][cols];

        sums = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            elements[i] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
