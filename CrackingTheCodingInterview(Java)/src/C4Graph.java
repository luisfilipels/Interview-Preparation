import java.util.ArrayList;
import java.util.Stack;

public interface C4Graph {

    class AdjMatrixGraph {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        AdjMatrixGraph (int nodeCount) {
            for (int i = 0; i < nodeCount; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < nodeCount; j++) {
                    graph.get(i).add(Integer.MAX_VALUE);
                }
            }
        }

        void setBidirEdge (int node1, int node2) {
            editBidirEdge(node1, node2, 1);
        }

        void editBidirEdge (int node1, int node2, int weight) {
            graph.get(node1).set(node2, weight);
            graph.get(node2).set(node1, weight);
        }

        boolean DFS (int start, int end) {
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    DFS(i, end, visited);
                }
            }
            if (visited[end]) {
                return true;
            } else {
                return false;
            }
        }

        private void DFS (int start, int end, boolean[]visited) {
            visited[start] = true;
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    DFS(i, end, visited);
                }
            }
        }

        Stack<Integer> cloneOf (Stack<Integer> stack) {
            Stack<Integer> returnStack = new Stack<>();
            Stack<Integer> auxStack = new Stack<>();
            while (!stack.empty()) {
                auxStack.add(stack.pop());
            }
            while (!auxStack.empty()) {
                returnStack.add(auxStack.pop());
            }
            return returnStack;
        }

        Stack<Integer> pathDFS (int start, int end) {
            Stack<Integer> returnStack = new Stack<>();
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            returnStack.add(start);
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    Stack<Integer> auxStack = pathDFS(i, end, visited, cloneOf(returnStack));
                    if (auxStack != null && auxStack.peek() == end) {
                        return auxStack;
                    }
                }
            }
            return returnStack;
        }

        Stack<Integer> pathDFS (int start, int end, boolean[] visited, Stack<Integer> stack) {
            stack.add(start);
            if (start == end) {
                return stack;
            }
            visited[start] = true;
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    Stack<Integer> auxStack = pathDFS(i, end, visited, cloneOf(stack));
                    if (auxStack != null && auxStack.peek() == end) {
                        return auxStack;
                    }
                }
            }
            return stack;
        }

    }

}
