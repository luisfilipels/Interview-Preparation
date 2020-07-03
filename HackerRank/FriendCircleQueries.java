package Extras.HackerRank;

import java.util.Arrays;
import java.util.HashMap;

public class FriendCircleQueries {

    //static int[] uf = new int[10000];
    //static int[] count = new int[10000];

    // Using hashmap, as to evade maximum memory usage restrictions when creating 2 arrays with 10^9 integer elements
    static HashMap<Integer, Integer> uf = new HashMap<>();
    static HashMap<Integer, Integer> count = new HashMap<>();

    static int max = 1;

    static void union(int p1, int p2) {
        if (!uf.containsKey(p1)) {
            uf.put(p1, p1);
            count.put(p1, 1);
        }

        if (!uf.containsKey(p2)) {
            uf.put(p2, p2);
            count.put(p2, 1);
        }

        int leaderCircle1 = find(p1);
        int leaderCircle2 = find(p2);

        if (leaderCircle1 == leaderCircle2) return;

        count.replace(leaderCircle2, count.get(leaderCircle2) + count.get(leaderCircle1));
        uf.replace(leaderCircle1, leaderCircle2);

        max = Math.max(count.get(leaderCircle2), max);
    }

    static int find(int person) {
        int root = person;

        while (uf.get(root) != root) {
            root = uf.get(root);
        }
        //while (uf[root] != root) {
        //    root = uf[root];
        //}

        while (person != root) {
            int next = uf.get(person);
            uf.replace(person, root);
            //uf[person] = root;
            person = next;
        }

        return root;
    }

    static int[] maxCircle (int[][] queries) {
        /*for (int i = 0; i < count.length; i++) {
            count[i] = 1;
            uf[i] = i;
        }*/
        int[] response = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            union(query[0], query[1]);
            response[i] = max;
        }
        return response;
    }

    public static void main(String[] args) {
        int [][] queries = {
                {1, 2},
                {1,3}
        };

        System.out.println(Arrays.toString(maxCircle(queries)));
    }

}
