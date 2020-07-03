package Extras.LeetCode;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    static class UnionFind {
        int [] array;   // The array with which we base our Union Find
        int [] size;    // Each position i represents the size of the component rooted at i
        HashMap<Integer, Integer> map = new HashMap<>();    // For quick access to each tuple (valueAtArray, index)

        UnionFind (int [] original) {
            array = new int[original.length];
            size = new int[original.length];
            for (int i = 0; i < original.length; i++) {
                map.put(original[i], i); // Creating the map.
                array[i] = i;            // Each position starts rooted at itself.
                size[i] = 1;             // Each component starts with size 1
            }
        }

        int find(int num) {
            int parent = map.get(num);          // Not the true parent (yet).
            int originalIndex = parent;
            while (array[parent] != parent) {
                parent = array[parent];
            }
            // Parent is now the root component of the number num. We now do path compression.
            while (originalIndex != parent) {
                int next = array[originalIndex];
                array[originalIndex] = parent;
                originalIndex = next;
            }

            return parent;
        }

        void union(int num1, int num2) {

            int num1Parent = find(num1);    // Start by finding the root of num1
            int num2Parent = find(num2);    // then num2

            if (num1Parent == num2Parent) return;

            if (size[num1Parent] < size[num2Parent]) {  // If the size of the component rooted at num1Parent is smaller than that of num2Parent, then it is more efficient to add to num2Parent the size of num1Parent
                size[num2Parent] += size[num1Parent];
                array[num1Parent] = num2Parent;
            } else {
                size[num1Parent] += size[num2Parent];
                array[num2Parent] = num1Parent;
            }
        }
    }

    private static int longestConsecutive(int [] nums) {
        UnionFind uf = new UnionFind(nums);
        for (int i = 0; i < nums.length; i++) {
            if (uf.map.containsKey(nums[i]-1)) {
                uf.union(nums[i],nums[i]-1);
            }
            if (uf.map.containsKey(nums[i]+1)) {
                uf.union(nums[i],nums[i]+1);
            }
        }
        int [] count = new int[nums.length]; // We count the number of different roots after the previous algorithm has been run.
        int max = 0;
        for (int i = 0; i < uf.array.length; i++) {
            uf.find(nums[i]);   // Needed because perhaps not all elements point directly to its root, which would break the count.
            count[uf.array[i]]++;
            max = Math.max(max, count[uf.array[i]]);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] input = new int[] {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(input));
    }

}
