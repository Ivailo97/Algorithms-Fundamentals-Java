import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] field = new char[rows][cols];
        initializeField(field, reader);
        char fillChar = reader.readLine().charAt(0);
        int[] startingPosition = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int x = startingPosition[0];
        int y = startingPosition[1];

        char charToReplace = field[startingPosition[0]][startingPosition[1]];

        floodFill(field, x, y, charToReplace, fillChar);
        printField(field);
    }

    private static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static void initializeField(char[][] field, BufferedReader reader) throws IOException {
        for (int i = 0; i < field.length; i++) {
            String[] line = reader.readLine().split("\\s+");
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = line[j].charAt(0);
            }
        }
    }

    private static void floodFill(char[][] field, int x, int y, char charToReplace, char fillChar) {

        if (x < 0 || x >= field.length || y < 0 || y >= field[x].length) {
            return;
        }

        if (field[x][y] != charToReplace) {
            return;
        }

        field[x][y] = fillChar;

        floodFill(field, x - 1, y, charToReplace, fillChar);
        floodFill(field, x + 1, y, charToReplace, fillChar);
        floodFill(field, x, y + 1, charToReplace, fillChar);
        floodFill(field, x, y - 1, charToReplace, fillChar);
    }
}
