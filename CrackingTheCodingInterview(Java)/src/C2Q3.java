public class C2Q3 {

    public static void deleteMiddle (C2LinkedList.Node node) {
        C2LinkedList.Node temp = node;
        node.data = temp.next.data;
        node.next = temp.next.next;
    }

    public static void main(String[] args) {
        int [] input = {1, 2, 3, 4, 5};
        C2LinkedList.LinkedList list = new C2LinkedList.LinkedList(input);
        deleteMiddle(list.head.next.next);
        System.out.println(list.toString());

    }

}
