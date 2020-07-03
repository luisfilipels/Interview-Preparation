package Extras.LeetCode;

import static Extras.LeetCode.KthLargestElement.swap;

public class FirstMissingPositive {

    static int partition(int[] A){
        int n=A.length;
        int q=-1;
        for(int i=0;i<n;i++){
            if(A[i]>0){
                q++;
                swap(A,q,i);
            }
        }
        return q;
    }

    static private int firstMissingPositive (int [] nums) {
        /*
        Suponhamos o caso {6, 4, 4, 3, 2, 1}. A resposta é 5.

        Observe que a resposta deve estar no intervalo de 1..tam(nums)+1. Portanto, para tam(nums) = 6, possíveis respostas
        seriam {1, 2, 3, 4, 5, 6, 7}, com 7 ocorrendo se todos os outros valores existirem na matriz.

        Podemos então obter a resposta marcando *índices* como estando presentes ou não no conteúdo da matriz. Para o caso
        inicial:

        índices:  0  1  2  3  4  5
        conteúdo: 6, 4, 4, 3, 2, 1
        valores:  1  2  3  4  5  6  7

        Marcamos uma posição como existente fazendo o mapa índice->conteúdo. Com indice = 0, conteúdo é 6. Podemos então
        dizer que o 6 está presente no conteúdo marcando conteúdo[6-1] como sendo negativo. 6 é valor que marcamos como
        presente.

        índices:  0  1  2  3  4   5
        conteúdo: 6, 4, 4, 3, 2, -1
        valores:  1  2  3  4  5   6  7

        Para indice = 1, observamos que ele mapeia para 4. Assim:

        índices:  0  1  2   3  4   5
        conteúdo: 6, 4, 4, -3, 2, -1
        valores:  1  2  3   4  5   6  7

        E assim por diante.

        Para matrizes com valores negativos, é necessário jogar os negativos para a direita. (partition)

         */
        int size = nums.length;
        if (size==0) return 1;
        int k = partition(nums) + 1;
        for (int i = 0; i < k; i++) {
            int indexToMark = Math.abs(nums[i]);
            if (indexToMark - 1 < k && nums[indexToMark - 1] > 0) {
                nums[indexToMark-1] = -nums[indexToMark-1];
            }
        }
        for (int i = 0; i < k; i++)
            if (nums[i] > 0)
                return i + 1;
        return k+1;
    }

    public static void main(String[] args) {
        int [] input = new int[] {1, 2, 0};
        System.out.println(firstMissingPositive(input));
    }

}
