package Extras.LeetCode;

import java.util.*;

public class KMostFrequent {

    // Accepted, but was very slow
    static public List<Integer> topKFrequent(int [] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> hash.get(y) - hash.get(x));
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) {
                hash.put(nums[i], 0);
                queue.add(nums[i]);
            } else {
                queue.remove(nums[i]);
                hash.replace(nums[i], hash.get(nums[i])+1);
                queue.add(nums[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            returnList.add(queue.remove());
        }
        return returnList;
    }

    // Recommended solution:
    /*public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }*/

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,1,1,2,2,2,3,3,3,3,4};
        System.out.println(topKFrequent(nums, 2));
    }

}
