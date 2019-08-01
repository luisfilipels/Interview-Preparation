public class C4TestTree {

    public static void main(String[] args) {
        C4Tree.BinaryCompleteTree tree = new C4Tree.BinaryCompleteTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);

        System.out.println(tree.inOrderTraversal());
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.postOrderTraversal());

        C4Tree.BinarySearchTree bst = new C4Tree.BinarySearchTree();

        bst.add(2);
        bst.add(3);
        bst.add(1);
        bst.add(3);
        bst.add(4);

        System.out.println(bst.search(4).value);
    }

}
