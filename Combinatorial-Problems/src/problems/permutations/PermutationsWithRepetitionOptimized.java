package problems.permutations;

import base.Problem;

import java.io.IOException;
import java.util.Arrays;

public class PermutationsWithRepetitionOptimized implements Problem {

    @Override
    public void solve() throws IOException {
        int[] arr = {3, 5, 1, 5, 5};
        Arrays.sort(arr);
        permute(arr, 0, arr.length - 1);
    }

    private void permute(int[] arr, int start, int end) {
        print(arr);
        for (int left = end - 1; left >= start; left--) {
            for (int right = left + 1; right <= end; right++) {
                if (arr[left] != arr[right]) {
                    swap(arr, left, right);
                    permute(arr, left + 1, end);
                }
            }
            int firstElement = arr[left];
            for (int i = left; i <= end - 1; i++) {
                arr[i] = arr[i + 1];
                arr[end] = firstElement;
            }
        }
    }

    private void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
}
