import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistanceBetweenVertices {

    public static int[][] graph;

    public static Map<Integer, Integer> indexMapper = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int vertices = Integer.parseInt(reader.readLine());
        int pairs = Integer.parseInt(reader.readLine());

        graph = new int[vertices + 1][];

        for (int i = 1; i <= vertices; i++) {

            String[] edges = reader.readLine().split(":");

            indexMapper.put(Integer.parseInt(edges[0]), i);

            if (edges.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(edges[1].split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
            }
        }

        while (pairs-- > 0) {

            int[] relation = Arrays.stream(reader.readLine().split("-"))
                    .mapToInt(Integer::parseInt).toArray();

            int source = relation[0];
            int dest = relation[1];

            System.out.printf("{%d, %d} -> ", source, dest);

            int[] prev = new int[graph.length];
            Arrays.fill(prev, -1);

            bfs(graph, indexMapper.get(source), indexMapper.get(dest), prev);

            int pathCount = 0;

            int parent = prev[indexMapper.get(dest)];

            while (parent != -1) {
                pathCount++;
                parent = prev[parent];
            }

            System.out.println(pathCount == 0 ? -1 : pathCount);
        }
    }

    private static void bfs(int[][] graph, int source, int dest, int[] prev) {

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);

        boolean[] visited = new boolean[graph.length];

        visited[source] = true;

        while (!queue.isEmpty()) {

            Integer node = queue.poll();

            if (node == dest) {
                return;
            }

            for (int i = 0; i < graph[node].length; i++) {
                int child = indexMapper.get(graph[node][i]);
                if (!visited[child]) {
                    prev[child] = node;
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }

        prev[source] = -1;
    }
}
