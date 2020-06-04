package problems.cinema;

import problems.Problem;

import java.io.IOException;
import java.util.Arrays;

public final class Cinema extends Problem {

    private static final String END = "generate";

    private static StringBuilder output;

    private String[] names;

    private String[] permute;

    private boolean[] taken;

    private boolean[] takenCopy;

    public Cinema() {
        super();
    }

    @Override
    public void solve() throws IOException {

        init();

        permute(0);

        System.out.println(output.toString().trim());
    }

    private void init() throws IOException {
        printInitMessage();

        names = reader.readLine().split(", ");
        taken = new boolean[names.length];
        output = new StringBuilder();

        String line;

        while (!(line = reader.readLine()).equals(END)) {
            String[] nameAndPlace = line.split(" - ");
            int index = Integer.parseInt(nameAndPlace[1]) - 1;
            int secondIndex = indexOf(names, nameAndPlace[0]);
            swap(names, index, secondIndex);
            taken[index] = true;
        }

        takenCopy = Arrays.copyOf(taken, taken.length);
        initPermute();
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Enter names separated with ', ' then enter names and position , enter 'generate' to generate all possibilities");
    }

    private void initPermute() {
        int size = getFreePlacesLength();
        permute = new String[size];
        for (int i = 0, j = 0; i < taken.length; i++) {
            if (!taken[i]) {
                permute[j++] = names[i];
            }
        }
    }

    private int getFreePlacesLength() {
        int count = 0;
        for (boolean taken : taken) {
            if (!taken) {
                count++;
            }
        }
        return count;
    }

    private int indexOf(String[] arr, String value) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void permute(int index) {
        if (index == permute.length) {
            mergeAndOut();
            takenCopy = Arrays.copyOf(taken, taken.length);
        } else {
            permute(index + 1);
            for (int i = index + 1; i < permute.length; i++) {
                swap(permute, index, i);
                permute(index + 1);
                swap(permute, index, i);
            }
        }
    }

    private void mergeAndOut() {

        for (String name : permute) {
            int index = getFirstFreeIndex();
            names[index] = name;
            takenCopy[index] = true;
        }

        updateOutput(names);
    }

    private int getFirstFreeIndex() {
        int index = -1;
        for (int i = 0; i < takenCopy.length; i++) {
            if (!takenCopy[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void swap(String[] arr, int firstIndex, int secondIndex) {
        String tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }

    private void updateOutput(String[] arr) {
        output.append(String.join(" ", arr)).append(System.lineSeparator());
    }
}
