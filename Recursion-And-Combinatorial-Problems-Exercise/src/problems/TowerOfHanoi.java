package problems;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public final class TowerOfHanoi extends Problem {

    private StringBuilder output;
    private Deque<Integer> source;
    private Deque<Integer> destination;
    private Deque<Integer> spare;
    private int disk;
    private int step;

    public TowerOfHanoi() {
        super();
        this.output = new StringBuilder();
        this.source = new ArrayDeque<>();
        this.destination = new ArrayDeque<>();
        this.spare = new ArrayDeque<>();
    }

    @Override
    public void solve() throws IOException {
        init();
        updateState();
        moveDisk(disk, source, destination, spare);
        System.out.print(output.toString());
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Enter number of disks: ");
    }

    private void init() throws IOException {
        printInitMessage();
        disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }
    }

    private void moveDisk(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            updateStepAndState();
        } else {
            moveDisk(disk - 1, source, spare, destination);
            moveDisk(1, source, destination, spare);
            moveDisk(disk - 1, spare, destination, source);
        }
    }

    private void updateState() {
        output.append("Source: ").append(formatRod(source))
                .append(System.lineSeparator())
                .append("Destination: ").append(formatRod(destination))
                .append(System.lineSeparator())
                .append("Spare: ").append(formatRod(spare))
                .append(System.lineSeparator())
                .append(System.lineSeparator());
    }

    private void updateStepAndState() {
        output.append("Step #").append(++step).append(": Moved disk").append(System.lineSeparator());
        updateState();
    }

    private String formatRod(Deque<Integer> rod) {
        return rod.stream().sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}

