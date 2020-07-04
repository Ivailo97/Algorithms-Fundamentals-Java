import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NuclearWaste {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static StringBuilder out = new StringBuilder();

    static int[] costs;

    static int[] prices;

    static long[] bestPrices;

    static int[] prevCount;

    public static void main(String[] args) throws IOException {

        costs = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        prices = new int[costs.length + 1];

        prices[0] = 0;
        int countToTransport = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= costs.length; i++) {
            prices[i] = costs[i - 1];
        }

        bestPrices = new long[countToTransport + 1];

        for (int i = 0; i <= countToTransport; i++) {
            if (i >= prices.length) {
                bestPrices[i] = bestPrices[i - 1] + bestPrices[1];
            } else {
                bestPrices[i] = prices[i];
            }
        }
        prevCount = new int[countToTransport + 1];

        for (int i = 1; i < countToTransport + 1; i++) {

            for (int j = 1; j <= i; j++) {

                long currentBest;

                if (j >= prices.length) {
                    currentBest = bestPrices[j] + bestPrices[i - j];
                } else {
                    currentBest = prices[j] + bestPrices[i - j];
                }

                if (currentBest < bestPrices[i]) {
                    bestPrices[i] = currentBest;
                    prevCount[i] = j;
                }
            }
        }

        out.append("Cost: ")
                .append(bestPrices[countToTransport])
                .append(System.lineSeparator());

        int count = countToTransport;

        while (prevCount[count] > 0) {
            out.append(prevCount[count])
                    .append(" => ").append(bestPrices[prevCount[count]])
                    .append(System.lineSeparator());
            count = count - prevCount[count];
        }

        out.append(count)
                .append(" => ")
                .append(bestPrices[count]);

        System.out.println(out.toString().trim());
    }
}
