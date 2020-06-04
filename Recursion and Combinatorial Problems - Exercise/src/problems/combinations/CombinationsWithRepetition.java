package problems.combinations;

import java.io.IOException;

public final class CombinationsWithRepetition extends Combinations {

    private int n;

    private int k;

    private int[] kSlots;

    public CombinationsWithRepetition() {
        super();
    }

    @Override
    public void solve() throws IOException {
        init();
        comb(0, 1);
    }

    private void init() throws IOException {
        printInitMessage();
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        kSlots = new int[k];
    }

    @Override
    protected void comb(int index, int start) {
        if (index == k) {
            print();
        } else {
            for (int i = start; i <= n; i++) {
                kSlots[index] = i;
                comb(index + 1, i);
            }
        }
    }

    private void print() {
        for (int element : kSlots) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
