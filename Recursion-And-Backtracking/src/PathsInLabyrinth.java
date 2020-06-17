import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathsInLabyrinth extends SolutionWithInput {

    private static final char WALL = '*';
    private static final char FREE = '-';
    private static final char EXIT = 'e';
    private static final char VISITED = 'V';
    private static final char RIGHT = 'R';
    private static final char LEFT = 'L';
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char START = 'S';

    private char[][] labyrinth;

    private List<Character> path;

    public PathsInLabyrinth() {
        super();
        this.path = new ArrayList<>();
    }

    @Override
    public void solve() throws IOException {

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        initLabyrinth(rows, cols);

        findPath(0, 0, START);
    }

    private void findPath(int row, int col, char dir) {

        if (!isInBounds(row, col)) {
            return;
        }

        path.add(dir);

        if (foundExit(row, col)) {

            printPath();

        } else if (isFree(row, col) && isNotVisited(row, col)) {

            mark(row, col);
            findPath(row, col + 1, RIGHT);
            findPath(row + 1, col, DOWN);
            findPath(row, col - 1, LEFT);
            findPath(row - 1, col, UP);
            unmark(row, col);
        }

        path.remove(path.size() - 1);
    }

    private void unmark(int row, int col) {
        labyrinth[row][col] = FREE;
    }

    private void mark(int row, int col) {
        labyrinth[row][col] = VISITED;
    }

    private void printPath() {

        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private boolean isNotVisited(int row, int col) {
        return labyrinth[row][col] != VISITED;
    }

    private boolean foundExit(int row, int col) {
        return labyrinth[row][col] == EXIT;
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < labyrinth.length && col >= 0 && col < labyrinth[row].length;
    }

    private boolean isFree(int row, int col) {
        return labyrinth[row][col] != WALL;
    }

    private void initLabyrinth(int rows, int cols) throws IOException {

        labyrinth = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            labyrinth[i] = reader.readLine().toCharArray();
        }
    }
}
