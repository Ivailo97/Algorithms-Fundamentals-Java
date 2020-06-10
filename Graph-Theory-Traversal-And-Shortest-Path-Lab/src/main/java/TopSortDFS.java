import java.io.IOException;
import java.util.*;

public class TopSortDFS {


    public static void main(String[] args) throws IOException {


    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {

        Set<String> cycles = new HashSet<>();

        Set<String> visited = new HashSet<>();

        List<String> sorted = new ArrayList<>();

        for (String node : graph.keySet()) {
            topSortDfs(sorted, visited, node, cycles, graph);
        }

        return sorted;
    }

    private static void topSortDfs(List<String> sorted, Set<String> visited, String node, Set<String> cycles, Map<String, List<String>> graph) {

        if (cycles.contains(node)) {
            throw new IllegalArgumentException();
        }

        if (!visited.contains(node)) {
            visited.add(node);
            cycles.add(node);

            for (String child : graph.get(node)) {
                topSortDfs(sorted, visited, child, cycles, graph);
            }
            cycles.remove(node);
            sorted.add(0, node);
        }
    }

}
