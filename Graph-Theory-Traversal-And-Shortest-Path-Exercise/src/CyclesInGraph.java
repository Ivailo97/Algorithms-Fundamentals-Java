import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CyclesInGraph {

    public static Map<String, List<String>> graph = new HashMap<>();

    public static Set<String> visited = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        String source = null;

        while (!line.equals("End")) {

            String[] tokens = line.split("-");

            if (source == null) {
                source = tokens[0];
            }

            graph.putIfAbsent(tokens[0], new ArrayList<>());
            graph.putIfAbsent(tokens[1], new ArrayList<>());

            graph.get(tokens[0]).add(tokens[1]);
            graph.get(tokens[1]).add(tokens[0]);

            line = reader.readLine();
        }

        boolean hasCycle = dfs(source, "none");

        System.out.println("Acyclic: " + (hasCycle ? "No" : "Yes"));
    }

    private static boolean dfs(String vertex, String parent) {

        visited.add(vertex);

        if (graph.get(vertex) == null) {
            return false;
        }

        for (String neighbor : graph.get(vertex)) {

            if (neighbor.equals(parent)) {
                continue;
            }

            if (visited.contains(neighbor)) {
                return true;
            }

            if (dfs(neighbor, vertex)) {
                return true;
            }
        }

        return false;
    }
}
