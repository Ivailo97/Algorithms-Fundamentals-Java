package problems.permutations;

import base.IOProblem;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PermutationsWithRepetition extends IOProblem {

    private String[] elements;

    public PermutationsWithRepetition() {
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

    public void permute(int index) {
        if (index == elements.length) {
            print(elements);
        } else {
            permute(index + 1);
            Set<String> swapped = new HashSet<>();
            swapped.add(elements[index]);
            for (int i = index + 1; i < elements.length; i++) {
                if (!swapped.contains(elements[i])) {
                    swap(elements, index, i);
                    permute(index + 1);
                    swap(elements, index, i);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private void swap(String[] arr, int firstIndex, int secondIndex) {
        String tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }
}
