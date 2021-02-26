import java.util.ArrayList;
import java.util.List;

public class DotProductOfSparseVectors {

    static class SparseVector {
        List<Integer> storeList = new ArrayList<>();

        SparseVector(int[] nums) {
            int lastNum = -1;
            int countZeroes = 0;
            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];

                if (lastNum == 0) {
                    if (currentNum == 0) {
                        countZeroes++;
                        continue;
                    } else {
                        storeList.add(countZeroes * -1);
                        countZeroes = 0;
                    }
                }
                if (currentNum != 0) storeList.add(currentNum);
                else {
                    countZeroes++;
                }
                lastNum = currentNum;
            }

            if (lastNum == 0) {
                storeList.add(countZeroes * -1);
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int i = 0, j = 0;
            int n = this.storeList.size();
            int m = vec.storeList.size();

            int acumulator = 0;

            while (i < n && j < m) {
                int atI = this.storeList.get(i);
                int atJ = vec.storeList.get(j);

                if (atI < 0 && atJ < 0) {
                    this.storeList.set(i, atI + 1);
                    vec.storeList.set(j, atJ + 1);
                    if (vec.storeList.get(j) == 0) j++;
                    if (this.storeList.get(i) == 0) i++;
                } else if (atI < 0) {
                    this.storeList.set(i, atI + 1);
                    if (this.storeList.get(i) == 0) i++;
                    j++;
                } else if (atJ < 0) {
                    vec.storeList.set(j, atJ + 1);
                    if (vec.storeList.get(j) == 0) j++;
                    i++;
                } else {
                    acumulator += (atI * atJ);
                    i++;
                    j++;
                }
            }

            return acumulator;
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[] {0,0,3,0,0,0,1,0,0,3,0,0,0,5};
        int [] arr2 = new int[] {0,5,0,2,5,4,0,0,0,0,3,0,0,0};

        var sp1 = new SparseVector(arr);
        var sp2 = new SparseVector(arr2);

        System.out.println(sp1.dotProduct(sp2));
    }

}
