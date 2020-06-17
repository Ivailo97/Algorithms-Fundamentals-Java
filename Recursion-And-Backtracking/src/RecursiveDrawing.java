import java.io.IOException;

public class RecursiveDrawing extends SolutionWithInput {

    public RecursiveDrawing() {
        super();
    }

    @Override
    public void solve() throws IOException {
        draw(Integer.parseInt(reader.readLine()));
    }

    private void draw(int count) {

        if (count == 0) {
            return;
        }

        printSymbol('*', count);
        draw(count - 1);
        printSymbol('#', count);
    }

    private void printSymbol(Character symbol, int count) {

        for (int i = 0; i < count; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
