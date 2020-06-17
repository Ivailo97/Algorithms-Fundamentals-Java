package problems.areas;

public final class Area implements Comparable<Area> {

    private int size;

    private int startRow;

    private int startCol;

    public Area(int startRow, int startCol, int size) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    @Override
    public int compareTo(Area o) {

        int result = o.getSize() - this.size;

        if (result == 0) {
            result = this.startRow - o.getStartRow();
        }

        if (result == 0) {
            result = this.startCol - o.getStartCol();
        }

        return result;
    }

    @Override
    public String toString() {
        return "Area #%d" + " at (" + startRow + ", " + startCol + "), size: " + size;
    }
}
