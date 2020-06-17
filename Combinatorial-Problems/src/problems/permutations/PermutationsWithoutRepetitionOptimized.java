package problems.permutations;

import base.IOProblem;

import java.io.IOException;

public class PermutationsWithoutRepetitionOptimized extends IOProblem {

    private String[] elements;

    public PermutationsWithoutRepetitionOptimized() {
        super();
    }

    @Override
    protected void init() throws IOException {
        elements = reader.readLine().split(SPLIT_PATTERN);
    }

    @Override
    public void solve() throws IOException {
        init();
        permute(0);
    }

    private void permute(int index) {
        if (index == elements.length) {
            print(elements);
        } else {
            permute(index + 1);
            for (int i = index + 1; i < elements.length; i++) {
                swap(elements, index, i);
                permute(index + 1);
                swap(elements, index, i);
            }
        }
    }

    private void swap(String[] arr, int firstIndex, int secondIndex) {
        String tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }
}
