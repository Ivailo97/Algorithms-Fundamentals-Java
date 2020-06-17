package problems.variations;

import base.IOProblem;

import java.io.IOException;

public class VariationsWithRepetitionsIterative extends IOProblem {

    private int n;
    private int k;
    private int[] arr;

    public VariationsWithRepetitionsIterative() {
        super();
    }

    @Override
    public void solve() throws IOException {
        init();
        while (true) {
            print(arr);
            int index = k - 1;
            while (index >= 0 && arr[index] == n - 1) {
                index--;
            }
            if (index < 0) {
                break;
            }
            arr[index]++;
            for (int i = index + 1; i < k; i++) {
                arr[i] = 0;
            }
        }
    }

    @Override
    protected void init() throws IOException {
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        arr = new int[k];
    }
}
