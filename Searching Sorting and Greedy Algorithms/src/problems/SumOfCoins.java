package problems;

import base.Problem;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public final class SumOfCoins extends Problem {

    private static final String SPLIT_DELIMITER = ", ";
    private static final String PRINT_DELIMITER = " -> ";
    private static final String POSSIBLE_COIN_VALUES = "Range of possible coin values: {1, 2, 5, 10, 20, 50}";
    private static final String INIT_FIRST_MSG = "Enter coins separated with ', '";
    private static final String INIT_SECOND_MSG = "Enter desired sum";

    private int[] coins;

    private int targetSum;

    private Map<Integer, Integer> usedCoins;

    @Override
    public void solve() throws IOException {
        init();
        chooseCoins();
        print();
    }

    @Override
    protected void init() throws IOException {
        System.out.println(INIT_FIRST_MSG);
        System.out.println(POSSIBLE_COIN_VALUES);
        coins = Arrays.stream(reader.readLine().split(SPLIT_DELIMITER)).mapToInt(Integer::parseInt).toArray();
        System.out.println(INIT_SECOND_MSG);
        targetSum = Integer.parseInt(reader.readLine());
        usedCoins = new LinkedHashMap<>();
        Arrays.sort(coins);
    }

    private void chooseCoins() {
        int currentSum = 0;
        int coinIndex = coins.length - 1;
        while (currentSum < targetSum && coinIndex >= 0) {
            int coin = coins[coinIndex];
            int count = (targetSum - currentSum) / coin;
            currentSum += count * coin;
            if (count != 0) {
                usedCoins.put(coin, count);
            }
            coinIndex--;
        }
    }

    private void print() {
        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + PRINT_DELIMITER + usedCoin.getValue());
        }
    }
}
