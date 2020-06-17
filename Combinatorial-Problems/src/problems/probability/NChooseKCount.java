package problems.probability;

import base.IOProblem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NChooseKCount extends IOProblem {

    private int n;
    private int k;
    private Map<String, Long> memo;

    @Override
    protected void init() throws IOException {
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        memo = new HashMap<>();
    }

    @Override
    public void solve() throws IOException {
        init();
        print(binom(n, k));
    }

    private long binom(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }

        String key = n + "" + k;

        if (!memo.containsKey(key)) {
            memo.put(key, binom(n - 1, k - 1) + binom(n - 1, k));
        }

        return memo.get(key);
    }
}
