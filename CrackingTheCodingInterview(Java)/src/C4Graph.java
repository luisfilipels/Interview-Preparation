import java.util.ArrayList;
import java.util.Collections;
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

        Stack<Integer> pathDFS (int start, int end) {
            Stack<Integer> returnStack = new Stack<>();
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            returnStack.add(start);
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    Stack<Integer> copyStack = (Stack<Integer>) returnStack.clone();
                    copyStack = pathDFS(i, end, visited, copyStack);
                    if (copyStack != null && copyStack.peek() == end) {
                        return copyStack;
                    }
                }
            }
            return returnStack;
        }

        private Stack<Integer> pathDFS (int start, int end, boolean[] visited, Stack<Integer> stack) {
            stack.add(start);
            if (start == end) {
                return stack;
            }
            visited[start] = true;
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    Stack<Integer> copyStack = (Stack<Integer>) stack.clone();
                    copyStack = pathDFS(i, end, visited, copyStack);
                    if (copyStack != null && copyStack.peek() == end) {
                        return copyStack;
                    }
                }
            }
            return stack;
        }

        ArrayList<Stack<Integer>> listPathsDFS (int start, int end) {
            ArrayList<Stack<Integer>> returnArray = new ArrayList<>();
            Stack<Integer> currentStack = new Stack<>();
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            currentStack.add(start);
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    Stack<Integer> copyStack = (Stack<Integer>) currentStack.clone();
                    copyStack = listPathsDFS(i, end, visited, copyStack, returnArray);
                    if (copyStack != null && copyStack.peek() == end) {
                        returnArray.add(copyStack);
                    }
                }
            }
            return returnArray;
        }

        private Stack<Integer> listPathsDFS (int start, int end, boolean[] visited, Stack<Integer> stack, ArrayList<Stack<Integer>> listPaths) {
            stack.add(start);
            if (start == end) {
                return stack;
            }
            visited[start] = true;
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    Stack<Integer> copyStack = (Stack<Integer>) stack.clone();
                    copyStack = pathDFS(i, end, visited, copyStack);
                    if (copyStack != null && copyStack.peek() == end) {
                        listPaths.add(copyStack);
                    }
                }
            }
            return stack;
        }

        boolean BFS (int start, int end) {
            ArrayList<Integer> queue = new ArrayList<>();
            queue.add(start);
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            while (!queue.isEmpty()) {
                int i = queue.remove(0);
                for (int j = 0; j < graph.size(); j++) {
                    if (!visited[j] && graph.get(i).get(j) != Integer.MAX_VALUE) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            if (visited[end]) {
                return true;
            }
            return false;
        }

        ArrayList<Integer> pathBFS (int start, int end) {
            ArrayList<Integer> returnArray = new ArrayList<>();
            ArrayList<Integer> queue = new ArrayList<>();
            boolean [] visited = new boolean[graph.size()];
            int [] traceback = new int[graph.size()];
            for (int i = 0; i < traceback.length; i++) {
                traceback[i] = Integer.MAX_VALUE;
            }
            visited[start] = true;
            queue.add(start);
            while (!queue.isEmpty()) {
                int i = queue.remove(0);
                for (int j = 0; j < graph.size(); j++) {
                    if (!visited[j] && graph.get(i).get(j) != Integer.MAX_VALUE) {
                        traceback[j] = i;
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            if (visited[end]) {
                int j = end;
                returnArray.add(end);
                while (traceback[j] != start) {
                    returnArray.add(traceback[j]);
                    j = traceback[j];
                }
                returnArray.add(start);
                Collections.reverse(returnArray);
                return returnArray;
            }
            return null;
        }

        ArrayList<ArrayList<Integer>> listPathsBFS (int start, int end) {
            ArrayList<ArrayList<Integer>> returnArray = new ArrayList<>();
            ArrayList<ArrayList<Integer>> queue = new ArrayList<>();
            ArrayList<Integer> currentPath = new ArrayList<>();
            ArrayList<boolean[]> queueVisited = new ArrayList<>();
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            queueVisited.add(visited);
            currentPath.add(start);
            queue.add(currentPath);
            while (!queue.isEmpty()) {
                currentPath = queue.remove(0);
                visited = queueVisited.remove(0);
                int last = currentPath.get(currentPath.size()-1);
                if (last == end) {
                    returnArray.add(currentPath);
                }
                for (int i = 0; i < graph.size(); i++) {
                    if (!visited[i] && graph.get(last).get(i) != Integer.MAX_VALUE) {
                        ArrayList<Integer> copyPath = (ArrayList<Integer>) currentPath.clone();
                        boolean [] newVisited = visited.clone();
                        newVisited[i] = true;
                        copyPath.add(i);
                        queueVisited.add(newVisited);
                        queue.add(copyPath);
                    }
                }
            }
            return returnArray;
        }

    }

}
