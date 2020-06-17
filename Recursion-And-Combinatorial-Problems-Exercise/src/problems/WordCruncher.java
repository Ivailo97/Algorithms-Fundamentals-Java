package problems;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public final class WordCruncher extends Problem {

    private String target;
    private Set<String> out;
    private List<String> words;
    private List<String> combined;
    private Map<Integer, List<String>> table;
    private Map<String, Integer> occurrences;

    public WordCruncher() {
        super();
        combined = new ArrayList<>();
        table = new HashMap<>();
        occurrences = new HashMap<>();
        out = new TreeSet<>();
    }

    @Override
    public void solve() throws IOException {
        init();
        permute(0);
        for (String str : out) {
            System.out.println(str);
        }
    }

    @Override
    protected void printInitMessage() {
        System.out.println("Enter subtexts separated with ', ' then the target word");
    }

    private void permute(int index) {
        if (index == target.length()) {
            print();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String str : strings) {
                if (occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    combined.add(str);
                    permute(index + str.length());
                    combined.remove(combined.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }
            }
        }
    }

    private void print() {
        String actual = String.join("", combined);
        if (actual.contains(target)) {
            out.add(String.join(" ", combined));
        }
    }

    private void init() throws IOException {
        printInitMessage();
        words = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        target = reader.readLine();
        words.removeIf(word -> !target.contains(word));
        for (String word : words) {
            occurrences.putIfAbsent(word, 0);
            occurrences.put(word, occurrences.get(word) + 1);
            int index = target.indexOf(word);
            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(word);
                index = target.indexOf(word, index + 1);
            }
        }
    }
}
