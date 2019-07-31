public class C4TestTree {

    public static void main(String[] args) {
        C4Tree.BinaryCompleteTree tree = new C4Tree.BinaryCompleteTree();

        tree.add(1);
        tree.add(2);
        tree.add(3);

        System.out.println(tree.inOrderTraversal());

    }

}
