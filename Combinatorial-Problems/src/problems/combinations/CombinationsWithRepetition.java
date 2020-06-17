package problems.combinations;

import base.IOProblem;

import java.io.IOException;

public class CombinationsWithRepetition extends IOProblem {

    private String[] elements;

    private String[] kSlots;

    @Override
    protected void init() throws IOException {
        elements = reader.readLine().split("\\s+");
        kSlots = new String[Integer.parseInt(reader.readLine())];
    }

    @Override
    public void solve() throws IOException {
        init();
        comb(0, 0);
    }

    private void comb(int index, int start) {
        if (index == kSlots.length) {
            print(kSlots);
        } else {
            for (int i = start; i < elements.length; i++) {
                kSlots[index] = elements[i];
                comb(index + 1, i);
            }
        }
    }
}
