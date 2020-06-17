package problems.areas;

import problems.Problem;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConnectedAreasInAMatrix extends Problem {

    private static final char WALL = '*';
    private static final char PATH = '-';
    private static final char VISITED = 'V';

    private Set<Area> areas;

    private char[][] field;

    private int size;

    private int totalAreas;

    public ConnectedAreasInAMatrix() {
        super();
        this.areas = new TreeSet<>();
    }

    @Override
    public void solve() throws IOException {
        init();

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (isPath(row, col)) {
                    size = 0;
                    totalAreas++;
                    findArea(row, col);
                    Area area = new Area(row, col, size);
                    areas.add(area);
                }
            }
        }

        print();
    }

    private void print() {
        AtomicInteger count = new AtomicInteger();
        System.out.println("Total areas found: " + totalAreas);
        areas.forEach(x -> System.out.println(String.format(x.toString(), count.incrementAndGet())));
    }

    private void init() throws IOException {
        printInitMessage();
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        field = new char[rows][cols];
        for (int i = 0; i < field.length; i++) {
            field[i] = reader.readLine().toCharArray();
        }
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Enter field dimensions and the field");
    }

    private boolean isPath(int row, int col) {
        return field[row][col] == PATH;
    }

    private void findArea(int row, int col) {

        if (outsideBounds(row, col) || isVisited(row, col) || field[row][col] == WALL) {
            return;
        }

        mark(row, col);

        findArea(row, col + 1);
        findArea(row + 1, col);
        findArea(row, col - 1);
        findArea(row - 1, col);
    }

    private boolean isVisited(int row, int col) {
        return field[row][col] == VISITED;
    }

    private void mark(int row, int col) {
        field[row][col] = VISITED;
        size++;
    }

    private boolean outsideBounds(int row, int col) {
        return row >= field.length || row < 0 || col >= field[row].length || col < 0;
    }
}
