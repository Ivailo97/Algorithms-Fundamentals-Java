package problems.permutations;

import base.IOProblem;

import java.io.IOException;

public class PermutationsWithoutRepetition extends IOProblem {

    private String[] elements;

    private String[] permutation;

    private boolean[] used;

    public PermutationsWithoutRepetition() {
        super();
    }

    @Override
    protected void init() throws IOException {
        elements = reader.readLine().split(SPLIT_PATTERN);
        permutation = new String[elements.length];
        used = new boolean[elements.length];
    }

    @Override
    public void solve() throws IOException {
        init();
        permute(0);
    }

    private void permute(int index) {
        if (index == elements.length) {
            print(permutation);
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permutation[index] = elements[i];
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }
}
