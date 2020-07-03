package Extras.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueRecByHeight {

// Em dúvida? No papel, ordene em ordem decrescente, pela altura. Em seguida, pecorra todas as posições, e insira ela
// na posição correta, colocando setas entre a posição inicial e a posiçao final. Você vai ver que o que está sendo feito
// são inserções no índice apontado por pessoa[1]!

    static public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, 0, people.length, (a,b) -> {
            if(a[0]!=b[0])
                return b[0]-a[0];
            return a[1]-b[1];
        });
        ArrayList<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = queue.get(i);
        }
        return people;
    }

    public static void main(String[] args) {
        int [][] people = { {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} };
        people = reconstructQueue(people);
        System.out.println(Arrays.deepToString(people));
        //System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

}
