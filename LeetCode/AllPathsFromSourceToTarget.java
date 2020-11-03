import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPathsFromSourceToTarget {

    private static List<List<Integer>> allPathsFromSourceToTarget (int [][] graph) {

        List<List<Integer>> results = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        dfs(graph, 0, currentPath, results);

        return results;
    }

    private static void dfs (int [][] graph, int currentVertex, List<Integer> currentPath, List<List<Integer>> results) {

        if (currentVertex == graph.length-1) {
            results.add(new ArrayList<>(currentPath));
            return;
        }

        for (int neighbor : graph[currentVertex]) {
            currentPath.add(neighbor);
            dfs(graph, neighbor, currentPath, results);
            currentPath.remove(currentPath.size()-1);
        }
    }

    /*
    // Solution using a parent array
    List<Integer> getPathFromParents (int [] parents) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentVertex = parents.length-1;
        while (currentVertex != 0) {
            result.add(currentVertex);
            currentVertex = parents[currentVertex];
        }
        result.add(currentVertex);
        Collections.reverse(result);
        return result;
    }

    void dfs (int [][] graph, int currentVertex, int[] parents, List<List<Integer>> results) {

        if (currentVertex == graph.length-1) {
            results.add(getPathFromParents(parents));
            return;
        }

        for (int neighbor : graph[currentVertex]) {
            parents[neighbor] = currentVertex;
            dfs(graph, neighbor, parents, results);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(graph, 0, new int[graph.length], results);

        return results;
    }

     */

    public static void main(String[] args) {

        int[][] graph = new int[][] {
                {},
        };

        System.out.println(allPathsFromSourceToTarget(graph));
    }

}
