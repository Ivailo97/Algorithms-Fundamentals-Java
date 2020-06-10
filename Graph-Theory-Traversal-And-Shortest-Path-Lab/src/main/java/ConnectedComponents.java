import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class ConnectedComponents {

    static boolean[] visited;

    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {

        graph = readGraph();

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        printComponents(connectedComponents);
    }

    private static void printComponents(List<Deque<Integer>> connectedComponents) {
        for (Deque<Integer> component : connectedComponents) {
            System.out.print("Connected component: ");
            while (!component.isEmpty()) {
                int node = component.pop();
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> readGraph() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line.isEmpty()) {
                graph.add(new ArrayList<>());
                continue;
            }

            List<Integer> children = stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            graph.add(children);
        }

        return graph;
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {

        visited = new boolean[graph.size()];

        List<Deque<Integer>> components = new ArrayList<>();

        for (int startNode = 0; startNode < graph.size(); startNode++) {

            if (!visited[startNode]) {
                Deque<Integer> currentComponents = new ArrayDeque<>();
                dfs(startNode, graph, currentComponents);
                components.add(currentComponents);
            }
        }

        return components;
    }

    private static void dfs(int node, List<List<Integer>> graph, Deque<Integer> currentComponents) {
        if (!visited[node]) {
            visited[node] = true;
            for (int child : graph.get(node)) {
                dfs(child, graph, currentComponents);
            }
            currentComponents.add(node);
        }
    }
}
