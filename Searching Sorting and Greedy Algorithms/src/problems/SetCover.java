package problems;

import base.Problem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public final class SetCover extends Problem {

    private static final String DELIMITER = ", ";
    private static final String REPLACE_PATTERN = "\\[|]";
    private static final String OUTPUT_TEMPLATE = "Sets to take (%d):%n";
    private static final String INIT_SETS_COUNT = "Enter number of sets";
    private static final String INIT_UNIVERSE_MSG = "Enter numbers separated with ', '";
    private static final String INIT_SETS = "Enter %d sets of numbers separated with '%s' each on new line ";

    private List<int[]> sets;
    private List<int[]> chosenSets;
    private Set<Integer> universe;

    public SetCover() {
        super();
    }

    @Override
    public void solve() throws IOException {
        init();
        chooseSets();
        print();
    }

    @Override
    protected void init() throws IOException {
        System.out.println(INIT_UNIVERSE_MSG);
        universe = stream(reader.readLine().split(DELIMITER))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());

        chosenSets = new ArrayList<>();
        sets = new ArrayList<>();

        System.out.println(INIT_SETS_COUNT);
        int numberOfSets = Integer.parseInt(reader.readLine());

        System.out.println(String.format(INIT_SETS, numberOfSets, DELIMITER));
        for (int i = 0; i < numberOfSets; i++) {
            sets.add(stream(reader.readLine().split(DELIMITER))
                    .mapToInt(Integer::parseInt).toArray());
        }
    }

    public void chooseSets() {
        while (!universe.isEmpty()) {
            int containedElementsCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int element : set) {
                    if (universe.contains(element)) {
                        count++;
                    }
                }
                if (containedElementsCount < count) {
                    containedElementsCount = count;
                    chosenSet = set;
                }
            }
            chosenSets.add(chosenSet);
            stream(chosenSet).forEach(universe::remove);
        }
    }

    private void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OUTPUT_TEMPLATE, chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll(REPLACE_PATTERN, ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
