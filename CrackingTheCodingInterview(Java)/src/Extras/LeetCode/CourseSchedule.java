package Extras.LeetCode;

import java.util.*;

public class CourseSchedule {

    // Solution using topological sort
    // https://www.youtube.com/watch?v=rG2-_lgcZzo
    private static boolean canFinish (int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        int [] indegrees = new int[numCourses];
        for (int [] course : prerequisites) {
            adjList.get(course[0]).add(course[1]);
            indegrees[course[1]]++;
        }

        int countOfVerticesVisited = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (indegrees[current] == 0) {
                countOfVerticesVisited++;
            }
            if (!adjList.containsKey(current)) {
                continue;
            }
            for (int neighbor : adjList.get(current)) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return countOfVerticesVisited == numCourses;
    }

    // My first answer. Passes, but is very slow. Can be improved by using topological sort.
    /*private static boolean canFinish (int numCourses, int [][] prerequisites) {
        ArrayList<Integer> [] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int [] course : prerequisites) {
            adjList[course[0]].add(course[1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<boolean[]> visitedQueue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            queue.add(i);
            visitedQueue.add(new boolean[numCourses]);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                boolean [] currentVisited = visitedQueue.poll();
                currentVisited[current] = true;
                for (int neighbor : adjList[current]) {
                    if (!currentVisited[neighbor]) {
                        queue.add(neighbor);
                        boolean [] newVisited = new boolean[numCourses];
                        for (int j = 0; j < numCourses; j++) {
                            newVisited[j] =  currentVisited[j];
                        }
                        visitedQueue.add(newVisited);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }*/

    public static void main(String[] args) {
        int [][] prerequisites = new int[][] {
                {1,0},{2,6},{1,7},{6,4},{7,0},{0,5}
        };
        System.out.println(canFinish(8, prerequisites));
    }

}
