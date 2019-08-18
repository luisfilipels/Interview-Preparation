import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public interface C4Graph {

    // Graph represented as an adjacency matrix
    class AdjMatrixGraph {

        // I utilized ArrayList instead of graph because I imagine that this would make it easier for me add or remove
        // nodes from the graph.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //TODO Add methods to remove and add new vertices

        AdjMatrixGraph (int nodeCount) {
            // Creates a 1D ArrayList
            for (int i = 0; i < nodeCount; i++) {
                graph.add(new ArrayList<>());
            }

            // Makes the previous 1D ArrayList into a 2D ArrayList, and
            // sets all positions to Integer.MAX_VALUE, which we will
            // treat as representing the absence of a connection between
            // two nodes
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


        // Determines if there is a route between node start and node end.
        boolean DFS (int start, int end) {
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {  // If the node hasn't been visited, and there is a connection...
                    DFS(i, end, visited);
                }
            }

            // If, by starting at start, we see that end has been visited, return true
            if (visited[end]) {
                return true;
            } else {
                return false;
            }
        }

        // Private helper method to DFS(start, end)
        private void DFS (int start, int end, boolean[]visited) {
            visited[start] = true;
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {  // See above
                    DFS(i, end, visited);
                }
            }
        }


        // Returns *A* path between start and end, not necessarily the shortest one.
        Stack<Integer> pathDFS (int start, int end) {
            Stack<Integer> returnStack = new Stack<>();
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            returnStack.add(start);
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    // We copy the current stack into a new one, so that we don't lose a reference to it when we call the private helper method
                    Stack<Integer> copyStack = pathDFS(i, end, visited, (Stack<Integer>) returnStack.clone());
                    if (copyStack != null && copyStack.peek() == end) { // If the last element to be added to the stack == end, that means me have found a path. We then return it.
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
                    Stack<Integer> copyStack = pathDFS(i, end, visited, (Stack<Integer>) stack.clone());
                    if (copyStack != null && copyStack.peek() == end) {
                        return copyStack;
                    }
                }
            }
            return stack;
        }

        // Similar to pathDFS, but returns all possible paths between start and end as an ArrayList of Stack.
        ArrayList<Stack<Integer>> listPathsDFS (int start, int end) {
            ArrayList<Stack<Integer>> returnArray = new ArrayList<>();  // We will pass this reference down the recursion stack, and eventually return it.
            Stack<Integer> currentStack = new Stack<>();
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            currentStack.add(start);
            for (int i = 0; i < graph.size(); i++) {
                if (!visited[i] && graph.get(start).get(i) != Integer.MAX_VALUE) {
                    Stack<Integer> copyStack = listPathsDFS(i, end, visited, (Stack<Integer>) currentStack.clone(), returnArray);
                    if (copyStack.peek() == end) {
                        returnArray.add(copyStack);     // If we have found a path, we add it to the list of paths that will be returned
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
                    copyStack = listPathsDFS(i, end, visited, copyStack, listPaths);
                    if (copyStack != null && copyStack.peek() == end) {
                        listPaths.add(copyStack);
                    }
                }
            }
            return stack;
        }

        // Similar to DFS in its rationale and return value.
        boolean BFS (int start, int end) {
            ArrayList<Integer> queue = new ArrayList<>();   // Utilizes an ArrayList, but treated as a queue.
            queue.add(start);
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            while (!queue.isEmpty()) {
                // We call 'i' the current node. We then check all of its adjacent vertices and add them to the queue.
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

        // Returns *A* path between start and end, not necessarily the shortest one.
        ArrayList<Integer> pathBFS (int start, int end) {
            ArrayList<Integer> returnArray = new ArrayList<>();
            ArrayList<Integer> queue = new ArrayList<>();
            boolean [] visited = new boolean[graph.size()];

            // We utilize int [] traceback in the following manner:
            // Since we are only interested in getting a path path between the two nodes (for this particular method), we consider
            // that for each vertex 'j' we reach, its traceback will be 'i', with 'i' being the node from which we came to arrive
            // at 'j'. So if we have the following traceback, with start = 3, end = 1:
            // node:    0   1   2   3   4
            // tr:      3   0   1  inf  0
            // Starting at end, we see that its traceback = 0. 0's traceback is 3, 3's traceback is infinity, thus our path, from end to start is:
            // 1 -> 0 -> 3
            // We invert this path and get the path from start to end.
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


        // Lists all paths from start to end utilizing BFS.
        ArrayList<ArrayList<Integer>> listPathsBFS (int start, int end) {
            ArrayList<ArrayList<Integer>> returnArray = new ArrayList<>();

            // This queue is meant for nodes. Works the same as the 'queue' utilized in previous methods
            ArrayList<ArrayList<Integer>> queue = new ArrayList<>();

            // Since we have multiple paths, we treat each path individually.
            ArrayList<Integer> currentPath = new ArrayList<>();

            // This one's a bit tricky. Since we don't utilize recursion in BFS, we need to find a way to, for each path
            // we have found so far, to keep the path in sync with its respective visited array. By utilizing a queue
            // whose inserts and removes happen at the same time as the ones in the other queue, we make sure the data that's
            // currently being utilized is the correct one for each node.
            ArrayList<boolean[]> queueVisited = new ArrayList<>();

            // queue and queueVisited could be grouped into an object, but I personally chose not to do so.

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

    class AdjListGraph {

        ArrayList<ArrayList<int []>> graph = new ArrayList<>();

        AdjListGraph (int nodeCount) {
            for (int i = 0; i < nodeCount; i++) {
                graph.add(new ArrayList<>());
            }
        }

        void setBidirEdge (int node1, int node2) {
            editBidirEdge(node1, node2, 1);
        }

        void editBidirEdge (int node1, int node2, int weight) {
            int [] vertexWeightTuple1 = {node2, weight};
            int [] vertexWeightTuple2 = {node1, weight};
            graph.get(node1).add(vertexWeightTuple1);
            graph.get(node2).add(vertexWeightTuple2);
        }

        boolean DFS (int start, int end) {
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            DFSHelper(start, end, visited);
            if (visited[end]) {
                return true;
            } else {
                return false;
            }
        }

        private void DFSHelper (int start, int end, boolean[]visited) {
            visited[start] = true;
            for (int i = 0; i < graph.get(start).size(); i++) {
                if (!visited[graph.get(start).get(i)[0]]) {
                    DFSHelper(graph.get(start).get(i)[0], end, visited);
                }
            }
        }

        Stack<Integer> pathDFS (int start, int end) {
            Stack<Integer> returnStack = new Stack<>();
            boolean [] visited = new boolean[graph.size()];
            visited[start] = true;
            return pathDFSHelper(start, end, visited, returnStack);
        }

        private Stack<Integer> pathDFSHelper (int start, int end, boolean[] visited, Stack<Integer> stack) {
            stack.add(start);
            if (start == end) {
                return stack;
            }
            visited[start] = true;
            for (int i = 0; i < graph.get(start).size(); i++) {
                if (!visited[graph.get(start).get(i)[0]]) {
                    Stack <Integer> copyStack;
                    copyStack = pathDFSHelper(graph.get(start).get(i)[0], end, visited, stack);
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
            for (int i = 0; i < graph.get(start).size(); i++) {
                if (!visited[graph.get(start).get(i)[0]]) {
                    Stack<Integer> copyStack = listPathsDFSHelper(graph.get(start).get(i)[0], end, visited, (Stack<Integer>) currentStack.clone(), returnArray);
                    if (copyStack.peek() == end) {
                        returnArray.add(copyStack);
                    }
                }
            }
            return returnArray;
        }

        private Stack<Integer> listPathsDFSHelper (int start, int end, boolean [] visited, Stack<Integer> stack, ArrayList<Stack<Integer>> listPaths) {
            stack.add(start);
            if (start == end) {
                return stack;
            }
            visited[start] = true;
            for (int i = 0; i < graph.get(start).size(); i++) {
                if (!visited[graph.get(start).get(i)[0]]) {
                    Stack<Integer> copyStack = listPathsDFSHelper(graph.get(start).get(i)[0], end, visited, (Stack<Integer>) stack.clone(), listPaths);
                    if (copyStack.peek() == end) {
                        listPaths.add(copyStack);
                    }
                }
            }
            return stack;
        }

    }

}
