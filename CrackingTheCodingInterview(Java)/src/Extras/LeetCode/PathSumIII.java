package Extras.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class PathSumIII {

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    /* // Minha solução. Funciona, porém muito ineficiente. static int count = 0;

    static private int pathSum (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, new ArrayList<>(), sum);
        return count;
    }

    static public void helper (TreeNode node, ArrayList<Integer> currentSums, int targetSum) {
        for (int i = 0; i < currentSums.size(); i++) {
            currentSums.set(i, currentSums.get(i) + node.val);
            if (currentSums.get(i) == targetSum) {
                count++;
            }
        }
        currentSums.add(node.val);
        if (currentSums.get(currentSums.size()-1) == targetSum) {
            count++;
        }
        if (node.left != null) {
            helper(node.left, new ArrayList<>(currentSums), targetSum);
        }
        if (node.right != null) {
            helper(node.right, new ArrayList<>(currentSums), targetSum);
        }
    }*/

    static public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        helper(root, 0, sum, preSum);
        return count;
    }

    static int count = 0;

    /*
        Para a seguinte árvore, com soma alvo = 8:
                   2
                   |
                  10
                 /  \
                5   -3
               / \    \
              3   2   11
             / \   \
            3  -2   1

        Se fizermos a soma acumulada a cada vértice:

                   2(2)
                    |
                  10(12)
                   /   \
                5(17)  -3(9)
               /   \       \
            3(20)  2(19)  11(20)
           /     \      \
          3(23) -2(18)  1(20)

        Observe que os caminhos válidos são:

        1.  5 -> 3
        2.  5 -> 2 -> 1
        3. -3 -> 11

        Como obter o valor de uma soma no meio da árvore? Note que para (5->3), por exemplo, a soma dos vértices acima
        desse caminho é 12. Logo, se fizermos uma subtração de currSum-target, deveremos ter como resultado 12. Se for esse
        o caso, é sinal de que a soma do obtida até o vértice atual menos o alvo indica que os vértices acima do caminho
        são tem soma 12, e logo, o caminho do vértice atual até os anteriores tem soma = 8.


     */

    static public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum)+1);
        }

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        //root.left.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(pathSum(root, 8));
    }

}
