import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoefficients {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static long[][] dp;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine());

        int k = Integer.parseInt(reader.readLine());

        dp = new long[n + 1][k + 1];

        System.out.println(binomial(n, k));
    }

    public static long binomial(int n, int k) {

        if (k == 0 || k == n) {
            return 1;
        }

        if (dp[n][k] == 0) {
            dp[n][k] = binomial(n - 1, k - 1) + binomial(n - 1, k);
        }

        return dp[n][k];
    }
}
