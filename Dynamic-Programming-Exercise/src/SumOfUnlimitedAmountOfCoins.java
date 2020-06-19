import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfUnlimitedAmountOfCoins {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] coins = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int targetSum = Integer.parseInt(reader.readLine());

        int[] dp = new int[targetSum + 1];

        dp[0] = 1;

        for (int coin : coins) {

            for (int i = coin; i <= targetSum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[targetSum]);
    }
}
