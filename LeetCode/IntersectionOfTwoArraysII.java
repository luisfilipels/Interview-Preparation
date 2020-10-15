import java.util.*;

public class IntersectionOfTwoArraysII {

    // O(n + m) time and space solution.
    private static int[] intersect (int[] nums1, int[] nums2) {
        LinkedHashMap<Integer, Integer> countNums1 = new LinkedHashMap<Integer, Integer>();
        LinkedHashMap<Integer, Integer> countNums2 = new LinkedHashMap<Integer, Integer>();
        for (int x : nums1) {
            countNums1.put(x, countNums1.getOrDefault(x, 0) + 1);
        }
        for (int x : nums2) {
            countNums2.put(x, countNums2.getOrDefault(x, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : countNums1.entrySet()) {
            if (countNums2.containsKey(entry.getKey())) {
                int min = Math.min(entry.getValue(), countNums2.get(entry.getKey()));
                int num = entry.getKey();
                for (int i = 0; i < min; i++) {
                    list.add(num);
                }
            }
        }
        int [] returnArray = new int[list.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = list.get(i);
        }
        return returnArray;
    }

    // O(min(n,m)) time and space solution
    private static int[] intersect2 (int[] nums1, int[] nums2) {
        int [] smaller = nums1.length < nums2.length ? nums1 : nums2;
        int [] larger = nums1.length >= nums2.length ? nums1 : nums2;

        HashMap<Integer, Integer> countSmaller = new HashMap<Integer, Integer>();
        for (int x : smaller) {
            countSmaller.put(x, countSmaller.getOrDefault(x, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x : larger) {
            if (countSmaller.containsKey(x)) {
                countSmaller.put(x, countSmaller.get(x)-1);
                list.add(x);
                if (countSmaller.get(x) == 0) countSmaller.remove(x);
            }
        }

        int [] returnArray = new int[list.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = list.get(i);
        }
        return returnArray;
    }

    // O(n log(n) + m log(m)) time and O(min(n, m)) space
    private static int[] intersect3 (int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int [] returnArray = new int[list.size()];
        for (i = 0; i < returnArray.length; i++) {
            returnArray[i] = list.get(i);
        }
        return returnArray;

    }

    public static void main(String[] args) {
        int [] input1 = new int[] {2, 2, 2, 2};
        int [] input2 = new int[] {1, 2, 2};

        System.out.println(Arrays.toString(intersect(input1, input2)));
    }

}
