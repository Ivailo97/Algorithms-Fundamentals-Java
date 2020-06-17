import java.io.IOException;

public class GenerateVector extends SolutionWithInput{

    public GenerateVector() {
        super();
    }

    @Override
    public void solve() throws IOException {

        int size = Integer.parseInt(reader.readLine());

        int[] vector = new int[size];

        generate(vector, 0);
    }

    private void printVector(int[] vector) {

        for (int value : vector) {
            System.out.print(value);
        }

        System.out.println();
    }

    private void generate(int[] vector, int index) {

        if (index == vector.length) {
            printVector(vector);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generate(vector, index + 1);
        }

    }
}
