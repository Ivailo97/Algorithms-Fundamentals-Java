package problems.cinema;

import problems.Problem;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class CinemaAuthorSolution extends Problem {

    private static final String END = "generate";
    private StringBuilder output;
    private String[] seats;
    private String[] permute;
    private boolean[] used;
    private List<String> people;

    public CinemaAuthorSolution() {
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
        output = new StringBuilder();
        people = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        seats = new String[people.size()];

        String line;
        while (!(line = reader.readLine()).equals(END)) {
            String[] nameAndPlace = line.split(" - ");
            String name = nameAndPlace[0];
            int index = Integer.parseInt(nameAndPlace[1]) - 1;
            seats[index] = name;
            people.remove(name);
        }

        permute = new String[people.size()];
        used = new boolean[people.size()];
    }

    private void permute(int index) {
        if (index == permute.length) {
            print();
        } else {
            for (int i = 0; i < permute.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permute[index] = people.get(i);
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private void print() {
        String[] out = new String[seats.length];
        for (int i = 0, j = 0; i < out.length; i++) {
            if (seats[i] != null) {
                out[i] = seats[i];
            } else {
                out[i] = permute[j++];
            }
        }
        updateOutput(out);
    }

    private void updateOutput(String[] out) {
        output.append(String.join(" ", out)).append(System.lineSeparator());
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Enter names separated with ', ' then enter names and position , enter 'generate' to generate all possibilities");
    }
}
