import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RoadReconstruction {

    static class Graph {

        private int V;

        private LinkedList<Integer>[] adj;
        int time = 0;
        static final int NIL = -1;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {

            visited[u] = true;

            disc[u] = low[u] = ++time;

            for (int v : adj[u]) {

                if (!visited[v]) {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u])
                        System.out.println(u + " " + v);
                } else if (v != parent[u])
                    low[u] = Math.min(low[u], disc[v]);
            }
        }

        void bridge() {
            boolean[] visited = new boolean[V];
            int[] disc = new int[V];
            int[] low = new int[V];
            int[] parent = new int[V];

            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
                visited[i] = false;
            }

            for (int i = 0; i < V; i++)
                if (!visited[i])
                    bridgeUtil(i, visited, disc, low, parent);
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int buildings = Integer.parseInt(reader.readLine());

        Graph graph = new Graph(buildings);

        int edgesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < edgesCount; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split(" - ")).mapToInt(Integer::parseInt).toArray();
            graph.addEdge(edgeInfo[0], edgeInfo[1]);
        }

        System.out.println("Important streets:");
        graph.bridge();
    }
}
