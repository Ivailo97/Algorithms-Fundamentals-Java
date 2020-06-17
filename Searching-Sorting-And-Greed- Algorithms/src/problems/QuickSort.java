package problems;

import base.Sort;

import java.io.IOException;

import static java.util.Arrays.stream;

public final class QuickSort extends Sort {

    private int[] numbers;

    public QuickSort() {
        super();
    }

    @Override
    public void solve() throws IOException {
        init();
        sort(numbers);
        print(numbers);
    }

    @Override
    protected void init() throws IOException {
        System.out.println(INIT_MESSAGE);
        numbers = stream(reader.readLine().split(DELIMITER))
                .mapToInt(Integer::parseInt).toArray();
    }

    @Override
    protected void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
