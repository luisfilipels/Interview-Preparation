import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int [] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();

        List<Integer> returnList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                returnList.add(i);
            }
        }

        int countOfVisitedWithIndegreeZero = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            countOfVisitedWithIndegreeZero++;
            for (int vertex : adjList.get(current)) {
                indegrees[vertex]--;
                if (indegrees[vertex] == 0) {
                    q.add(vertex);
                    returnList.add(vertex);
                }
            }
        }

        if (countOfVisitedWithIndegreeZero == numCourses) {
            int [] returnArray = new int[returnList.size()];
            for (int i = 0; i < returnList.size(); i++) {
                returnArray[i] = returnList.get(i);
            }
            return returnArray;
        } else {
            return new int[0];
        }

    }

}
