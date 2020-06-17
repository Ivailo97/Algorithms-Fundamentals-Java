import java.io.IOException;

public class RecursiveFactorial extends SolutionWithInput {

    public RecursiveFactorial() {
        super();
    }

    @Override
    public void solve() throws IOException {

        int n = Integer.parseInt(reader.readLine());

        int result = fact(n);

        System.out.println(result);
    }

    private int fact(int n) {

        if (n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }
}
