package problems;

import java.io.IOException;

public final class NestedLoopsToRecursion extends Problem {

    private int n;

    private int[] arr;

    public NestedLoopsToRecursion() {
        super();
    }

    @Override
    public void solve() throws IOException {
        n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        permute(0);
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Number of loops");
    }

    private void permute(int index) {
        if (index == n) {
            print();
        } else {
            for (int i = 1; i <= n; i++) {
                arr[index] = i;
                permute(index + 1);
            }
        }
    }

    private void print() {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
