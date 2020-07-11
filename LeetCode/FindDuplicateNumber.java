package Extras.LeetCode;

public class FindDuplicateNumber {

    static int findDuplicate(int [] nums) { // Desenhar para facilitar compreensão
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise]; // Avança uma unidade
            hare = nums[nums[hare]]; // Avança duas
        } while (tortoise != hare);
        int ptr1 = nums[0];
        int ptr2 = tortoise; // Poderia ser hare. Só queremos o ponto em que os dois se encontram
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    public static void main(String[] args) {
        int [] input = new int[] {2,3,1,2};
        System.out.println(findDuplicate(input));
        //System.out.println(findDuplicateWithVariableStartAndEnd(input));
    }

}
