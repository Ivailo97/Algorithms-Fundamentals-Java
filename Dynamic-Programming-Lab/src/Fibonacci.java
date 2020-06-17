import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

    static long[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        memo = new long[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        System.out.println(fib(n));
    }

    public static long fib(int n) {

        if (n <= 2) {
            return 1;
        }

        if (memo[n] == 0) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }

        return memo[n];
    }
}
