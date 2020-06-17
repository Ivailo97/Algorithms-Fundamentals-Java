package problems;

import java.io.IOException;
import java.util.Arrays;

public final class ReverseArray extends Problem {

    private int[] numbers;

    public ReverseArray() {
        super();
    }

    @Override
    public void solve() throws IOException {
        init();
        reverse(0);
        print();
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Enter numbers: ");
    }

    private void init() throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void reverse(int index) {

        if (index == numbers.length / 2) {
            return;
        }

        swap(index, numbers.length - index - 1);

        reverse(index + 1);
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }

    private void print() {
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
    }
}
