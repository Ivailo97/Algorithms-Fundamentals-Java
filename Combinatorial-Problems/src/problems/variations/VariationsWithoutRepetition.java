package problems.variations;

import base.IOProblem;

import java.io.IOException;

public class VariationsWithoutRepetition extends IOProblem {

    private String[] elements;
    private String[] kSlots;
    private boolean[] used;

    public VariationsWithoutRepetition() {
        super();
    }

    @Override
    public void solve() throws IOException {
        init();
        variations(0);
    }

    @Override
    protected void init() throws IOException {
        elements = reader.readLine().split(SPLIT_PATTERN);
        used = new boolean[elements.length];
        kSlots = new String[Integer.parseInt(reader.readLine())];
    }

    private void variations(int index) {

        if (index == kSlots.length) {
            print(kSlots);
        } else {
            for (int i = 0; i < elements.length; i++) {

                if (!used[i]) {
                    used[i] = true;
                    kSlots[index] = elements[i];
                    variations(index + 1);
                    used[i] = false;
                }
            }
        }
    }
}
