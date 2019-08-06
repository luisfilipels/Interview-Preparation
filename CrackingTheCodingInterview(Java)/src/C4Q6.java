public class C4Q6 {

    static class TreeNodeWithLinkToParent {

        int value;
        TreeNodeWithLinkToParent parent;
        TreeNodeWithLinkToParent left;
        TreeNodeWithLinkToParent right;

        TreeNodeWithLinkToParent (TreeNodeWithLinkToParent parent, int value) {
            this.parent = parent;
            this.value = value;
        }
    }

    static TreeNodeWithLinkToParent successor (TreeNodeWithLinkToParent node) {
        if (node.right == null) {
            TreeNodeWithLinkToParent temp = node;
            TreeNodeWithLinkToParent upUntilRight = temp.parent;
            while (upUntilRight != null && upUntilRight.left != temp) {
                temp = upUntilRight;
                upUntilRight = upUntilRight.parent;
            }
            return upUntilRight;
        }
        TreeNodeWithLinkToParent temp = node.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;

    }

    public static void main(String[] args) {
        TreeNodeWithLinkToParent root = new TreeNodeWithLinkToParent(null, 8);
        root.left = new TreeNodeWithLinkToParent(root, 3);
        root.left.left = new TreeNodeWithLinkToParent(root.left, 1);
        root.left.right = new TreeNodeWithLinkToParent(root.left, 6);
        root.right = new TreeNodeWithLinkToParent(root, 10);
        root.right.right = new TreeNodeWithLinkToParent(root.right, 14);
        root.right.right.left = new TreeNodeWithLinkToParent(root.right.right, 13);
        root.left.right.left = new TreeNodeWithLinkToParent(root.left.right, 4);

        System.out.println(successor(root.left.right).value);

    }

}
