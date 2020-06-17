package problems;

import base.Sort;

import java.io.IOException;

import static java.util.Arrays.*;

public final class MergeSort extends Sort {

    private int[] numbers;

    public MergeSort() {
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

        if (arr.length == 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = copyOfRange(arr, 0, mid);
        int[] right = copyOfRange(arr, mid, arr.length);

        sort(left);
        sort(right);

        int mainIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[mainIndex] = left[leftIndex];
                leftIndex++;
            } else {
                arr[mainIndex] = right[rightIndex];
                rightIndex++;
            }
            mainIndex++;
        }

        while (leftIndex < left.length) {
            arr[mainIndex] = left[leftIndex];
            mainIndex++;
            leftIndex++;
        }

        while (rightIndex < right.length) {
            arr[mainIndex] = right[rightIndex];
            mainIndex++;
            rightIndex++;
        }
    }
}
