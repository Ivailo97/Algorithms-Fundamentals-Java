package problems.variations;

import base.IOProblem;

import java.io.IOException;

public class VariationsWithRepetition extends IOProblem {

    private String[] elements;
    private String[] kSlots;

    public VariationsWithRepetition() {
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
        kSlots = new String[Integer.parseInt(reader.readLine())];
    }

    private void variations(int index) {
        if (index == kSlots.length) {
            print(kSlots);
        } else {
            for (String element : elements) {
                kSlots[index] = element;
                variations(index + 1);
            }
        }
    }
}
