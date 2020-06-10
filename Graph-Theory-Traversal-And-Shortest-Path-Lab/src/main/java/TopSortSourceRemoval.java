import java.io.IOException;
import java.util.*;

public class TopSortSourceRemoval {

    public static void main(String[] args) throws IOException {

    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {

        Map<String, Integer> predecessorCount = getPredecessorCount(graph);

        List<String> sorted = new ArrayList<>();

        while (true) {

            String nodeToRemove = graph
                    .keySet()
                    .stream()
                    .filter(k -> predecessorCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (nodeToRemove == null) {
                break;
            }

            for (String child : graph.get(nodeToRemove)) {
                predecessorCount.put(child, predecessorCount.get(child) - 1);
            }

            graph.remove(nodeToRemove);
            sorted.add(nodeToRemove);
        }

        if (!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getPredecessorCount(Map<String, List<String>> graph) {

        Map<String, Integer> predecessorCount = new HashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            predecessorCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                predecessorCount.putIfAbsent(child, 0);
                predecessorCount.put(child, predecessorCount.get(child) + 1);
            }
        }

        return predecessorCount;
    }
}
