import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO : FIXME
public class Salaries {

    public static List<List<Integer>> graph = new ArrayList<>();

    public static int[] salaries;

    public static int[] managersCount;

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int employees = Integer.parseInt(reader.readLine());

        salaries = new int[employees];
        visited = new boolean[employees];
        managersCount = new int[employees];

        for (int i = 0; i < employees; i++) {

            graph.add(new ArrayList<>());

            String line = reader.readLine();

            for (int emp = 0; emp < line.length(); emp++) {

                char letter = line.charAt(emp);

                if (letter == 'Y') {
                    managersCount[emp]++;
                    graph.get(i).add(emp);
                }
            }
        }

        List<Integer> sources = new ArrayList<>();

        for (int i = 0; i < managersCount.length; i++) {
            if (managersCount[i] == 0) {
                sources.add(i);
            }
        }

        for (Integer source : sources) {
            dfs(source);
        }

        int sum = Arrays.stream(salaries).sum();

        System.out.println(sum);
    }

    private static void dfs(int vertex) {

        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;

        for (Integer child : graph.get(vertex)) {
            dfs(child);
        }

        int sum = graph.get(vertex).stream().mapToInt(v -> salaries[v]).sum();
        salaries[vertex] = sum == 0 ? 1 : sum;
    }
}
