package Extras.HackerRank;

public class HuffmanDecoding {

    static class Node {
        int frequency; // the frequency of this tree
        char data;
        Node left, right;
    }
    /*
                    fi, 5
                  0 /    \ 1
                 fi,2     A,3
              0 /   1 \
              B,1     C,1

              s="1001011"
                       i
             sb=ABACA
     */

    static void decode(String s, Node root) {
        int currentIndex = 0;
        StringBuilder sb = new StringBuilder();

        while (currentIndex < s.length()) {
            Node temp = root;

            while (!(temp.left == null && temp.right == null) && currentIndex < s.length()) {
                if (s.charAt(currentIndex) == '0') {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
                currentIndex++;
            }
            sb.append(temp.data);
        }

        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        Node root = new Node();
        root.left = new Node();
        root.right = new Node();
        root.left.left = new Node();
        root.left.right = new Node();
        root.right.data = 'A';
        root.left.left.data = 'B';
        root.left.right.data = 'C';

        decode("1001011", root);
    }

}
