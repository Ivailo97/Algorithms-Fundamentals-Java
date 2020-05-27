import java.io.IOException;

public class RecursiveFibonacci extends SolutionWithInput {

    private static final int MAX_FIB = 500;

    private long[] memo;

    public RecursiveFibonacci() {
        super();
        this.memo = new long[MAX_FIB];
    }

    @Override
    public void solve() throws IOException {

        int n = Integer.parseInt(reader.readLine());

        long result = fib(n);

        System.out.println(result);
    }

    private long fib(int n) {

        if (n <= 1) {
            return 1;
        }

        if (memo[n] == 0) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }

        return memo[n];
    }
}
