package Extras.LeetCode;

import java.util.Deque;

public class SerializeAndDeserializeBinTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private static class Codec {

        String serialize (TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            String s = sb.toString();
            s = s.substring(0, s.length()-1);
            return s;
        }

        void serializeHelper (TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("X");
                return;
            }
            sb.append(root.val);
            sb.append(",");
            if (root.left != null) {
                serializeHelper(root.left, sb);
            } else {
                sb.append("X,");
            }
            if (root.right != null) {
                serializeHelper(root.right, sb);
            } else {
                sb.append("X,");
            }
        }

        TreeNode deserialize (String data) {
            String [] nodeValues = data.split(",");
            int [] d = new int[1]; // "Pass by reference"
            return deserializeHelper(nodeValues, d);
        }

        TreeNode deserializeHelper (String [] data, int[] pos) {
            int i = pos[0];
            if (data[i].equals("X") || data[i].equals("")) {
                pos[0]++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(data[i]));
            pos[0]++;
            node.left = deserializeHelper(data, pos);
            node.right = deserializeHelper(data, pos);
            return node;
        }
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);*/
        TreeNode root = null;
        Codec codec = new Codec();
        String s = codec.serialize(root);

        TreeNode newRoot = codec.deserialize(s);

        System.out.println(root.left.left.val);

    }

}
