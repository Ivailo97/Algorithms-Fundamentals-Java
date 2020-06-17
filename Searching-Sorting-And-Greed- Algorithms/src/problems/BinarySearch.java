package problems;

import base.Problem;

import java.io.IOException;
import java.util.Arrays;

public final class BinarySearch extends Problem {

    private static final String FIRST_MESSAGE = "Enter numbers";
    private static final String SECOND_MESSAGE = "Enter number to search";
    private static final String DELIMITER = "\\s+";

    private int[] numbers;

    private int key;

    public BinarySearch() {
        super();
    }

    @Override
    public void solve() throws IOException {
        init();
        System.out.println(indexOfKey());
    }

    @Override
    protected void init() throws IOException {
        System.out.println(FIRST_MESSAGE);
        numbers = Arrays.stream(reader.readLine().split(DELIMITER)).mapToInt(Integer::parseInt).toArray();
        System.out.println(SECOND_MESSAGE);
        key = Integer.parseInt(reader.readLine());
        Arrays.sort(numbers);
    }

    private int indexOfKey() {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < numbers[mid]) {
                end = mid - 1;
            } else if (key > numbers[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
