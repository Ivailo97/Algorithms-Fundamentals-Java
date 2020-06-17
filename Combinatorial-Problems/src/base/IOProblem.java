package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public abstract class IOProblem implements Problem {

    protected static final String DELIMITER = " ";
    protected static final String SPLIT_PATTERN = "\\s+";

    protected BufferedReader reader;

    protected IOProblem() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    abstract protected void init() throws IOException;

    protected void print(String[] arr) {
        System.out.println(String.join(DELIMITER, arr));
    }

    protected void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    protected void print(long number) {
        System.out.println(number);
    }
}
