package problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SchoolTeams extends Problem {

    private static final int BOYS_COUNT = 2;
    private static final int GIRLS_COUNT = 3;
    private static final String DELIMITER = ", ";

    private String[] boys;
    private String[] boysSlots;
    private List<String[]> boysCombinations;

    private String[] girls;
    private String[] girlsSlots;
    private List<String[]> girlsCombinations;

    public SchoolTeams() {
        super();
        boysCombinations = new ArrayList<>();
        boysSlots = new String[BOYS_COUNT];
        girlsSlots = new String[GIRLS_COUNT];
        girlsCombinations = new ArrayList<>();
    }

    @Override
    public void solve() throws IOException {
        init();
        comb(boys, boysSlots, boysCombinations, 0, 0);
        comb(girls, girlsSlots, girlsCombinations, 0, 0);
        print();
    }

    private void print() {
        StringBuilder result = new StringBuilder();
        for (String[] gCombs : girlsCombinations) {
            for (String[] bCombs : boysCombinations) {
                result.append(String.join(DELIMITER, gCombs)).append(DELIMITER)
                        .append(String.join(DELIMITER, bCombs)).append(System.lineSeparator());
            }
        }

        System.out.println(result.toString().trim());
    }

    private void init() throws IOException {
        printInitMessage();
        girls = reader.readLine().split(DELIMITER);
        boys = reader.readLine().split(DELIMITER);
    }

    private void comb(String[] elements, String[] slots, List<String[]> container, int index, int start) {
        if (index == slots.length) {
            container.add(slots.clone());
        } else {
            for (int i = start; i < elements.length; i++) {
                slots[index] = elements[i];
                comb(elements, slots, container, index + 1, i + 1);
            }
        }
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Enter girl names separated with ', ' then boy names");
    }
}
