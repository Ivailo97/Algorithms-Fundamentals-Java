import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BlackMesa {

    static List<List<Integer>> graph = new ArrayList<>();

    static boolean[] visited;

    static StringBuilder out = new StringBuilder();

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] edges = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(edges[0]).add(edges[1]);
        }

        visited = new boolean[n + 1];

        int start = Integer.parseInt(reader.readLine().trim());
        int end = Integer.parseInt(reader.readLine().trim());

        path(start, end);

        visited = new boolean[n + 1];

        if (!visited[start]) {
            visited[start] = true;
            for (int child : graph.get(start)) {
                markNodes(child);
            }
        }
        markNodes(start);

        out.append(System.lineSeparator());
        printAllVisitedVersions();
    }

    private static void printAllVisitedVersions() {
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                out.append(i).append(" ");
            }
        }
        System.out.println(out);
    }

    private static void markNodes(int start) {
        if (!visited[start]) {
            visited[start] = true;
            for (int child : graph.get(start)) {
                markNodes(child);
            }
        }
    }

    private static void path(int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            out.append(node).append(" ");

            if (node == end) {
                return;
            }
            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }
}
