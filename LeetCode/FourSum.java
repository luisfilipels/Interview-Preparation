import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length <= 3) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> returnList = new LinkedList<>();

        int currentA = nums[0];
        for (int a = -1; a < nums.length - 3; a++) {
            if (a == -1) {
                a++;
            } else {
                while (a < nums.length - 3 && nums[a] == currentA) a++;
                if (a == nums.length - 3) break;
            }
            currentA = nums[a];
            int currentB = nums[a+1];
            for (int b = a; b < nums.length - 2; b++) {
                if (b == a) {
                    b++;
                } else {
                    while (b < nums.length - 2 && nums[b] == currentB) b++;
                    if (b == nums.length - 2) break;
                }
                currentB = nums[b];

                int c = b + 1;
                int d = nums.length - 1;

                while (c < d) {
                    int result = nums[a] + nums[b] + nums[c] + nums[d];
                    if (result >= target) {
                        if (result == target) {
                            returnList.add(new LinkedList<>());
                            int m = returnList.size();
                            returnList.get(m-1).add(nums[a]);
                            returnList.get(m-1).add(nums[b]);
                            returnList.get(m-1).add(nums[c]);
                            returnList.get(m-1).add(nums[d]);
                        }
                        int currentEnd = nums[d];
                        while (c < d && nums[d] == currentEnd) d--;
                    } else {
                        int currentStart = nums[c];
                        while (c < d && nums[c] == currentStart) c++;
                    }
                }
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        //int [] nums = new int[] {-1,0,1,2,-1,-4};
        //int [] nums = new int[] {-6, -1, 1, 0, -8, 2, 6, 4};
        int [] nums = new int[] {0,3,4,-2,-1,3,3,3,1};
        //int [] nums = new int[] {0,0,0,0};
        System.out.println(fourSum(nums, 2));
    }

}
