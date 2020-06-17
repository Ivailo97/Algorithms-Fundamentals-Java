package base;

public abstract class Sort extends Problem {

    protected static final String INIT_MESSAGE = "Enter numbers separated with space";

    protected static final String DELIMITER = "\\s+";

    protected Sort() {
        super();
    }

    protected abstract void sort(int[] arr);

    protected void print(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
