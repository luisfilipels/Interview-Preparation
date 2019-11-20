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

    /*
    // As seguintes soluções estão ERRADAS (para o site), pois só funcionam caso o elemento duplicado apareça uma única vez
    static int findDuplicate (int [] nums) {
        int xor = 1; // xor inicia com o menor valor que aparece no array
        for (int i = 2; i < nums.length; i++) {
            xor = xor ^ i; // fazemos xor em todos os elementos, até n-1 (que é o valor máximo que esperamos encontrar no array)
            // dessa forma, teremos feito um xor uma vez em todos os elementos, sem o duplicado
        }
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i]; // agora fazemos um xor em todos os elementos que realmente estão no array. O elemento duplicado terá aparecido *3* vezes, uma no primeiro for, e duas neste. Todos os outros
            // elementos terão sido anulados. Dois dos repetidos se anulam, sobrando apenas um que não foi repetido.
        }
        return xor;
        // Este algoritmo é válido para o intervalo entre 1 e n-1 de valores, com n sendo o tamanho de nums.
    }

    // Generalizando, para um valor mínimo qualquer, e máximo qualquer
    static int findDuplicateWithVariableStartAndEnd (int [] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int xor = min;
        for (int i = min + 1; i < max + 1; i++) {
            xor = xor ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
    */
    public static void main(String[] args) {
        int [] input = new int[] {2,3,1,2};
        System.out.println(findDuplicate(input));
        //System.out.println(findDuplicateWithVariableStartAndEnd(input));
    }

}
