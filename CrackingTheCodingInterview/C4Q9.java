import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class C4Q9 {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode (int val) {
            this.val = val;
        }

        void createLeft (int val) {
            left = new TreeNode(val);
        }

        void createRight (int val) {
            right = new TreeNode(val);
        }
    }

    static ArrayList<String> bstSequences (TreeNode root) {
        HashSet<String> hash = new HashSet<>();
        helper(root, "", new ArrayList<>(), hash);
        int maxSize = 0;
        for (String s: hash) {
            maxSize = Math.max(maxSize, s.length());
        }
        ArrayList<String> toRemove = new ArrayList<>();
        for (String s: hash) {
            if (s.length() != maxSize) {
                toRemove.add(s);
            }
        }
        for (String r : toRemove) {
            hash.remove(r);
        }
        ArrayList<String> returnList = new ArrayList<>();
        for (String s : hash) {
            returnList.add(s);
        }
        return returnList;
    }

    static void helper (TreeNode current, String currentString, ArrayList<TreeNode> options, HashSet<String> hash) {
        if (current == null) return;
        currentString += " " + current.val;
        options.remove(current);
        if (current.left != null) {
            options.add(current.left);
        }
        if (current.right != null) {
            options.add(current.right);
        }
        for (TreeNode t : options) {
            helper(t, currentString, new ArrayList<>(options), hash);
        }
        hash.add(currentString);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.createLeft(2);
        root.createRight(5);
        root.left.createLeft(1);
        root.left.createRight(3);
        root.right.createRight(6);

        ArrayList<String> result = bstSequences(root);
        for (String s : result) {
            System.out.println(s);
        }
    }

}
