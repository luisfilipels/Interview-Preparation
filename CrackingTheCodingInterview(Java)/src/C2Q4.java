public class C2Q4 {

    public static C2LinkedList.LinkedList partition (C2LinkedList.LinkedList list, int x) {
        C2LinkedList.Node temp = list.head;
        C2LinkedList.LinkedList less = new C2LinkedList.LinkedList();
        C2LinkedList.LinkedList more = new C2LinkedList.LinkedList();
        while (temp.next != null) {
            if (temp.data < x) {
                less.append(temp.data);
            } else {
                more.append(temp.data);
            }
            temp = temp.next;
        }
        if (temp.data < x) {
            less.append(temp.data);
        } else {
            more.append(temp.data);
        }
        less.appendNodeToTail(more.head);
        return less;
    }

    public static void main(String[] args) {
        int [] input = {5, 8, 5, 10, 2, 1};
        C2LinkedList.LinkedList list = new C2LinkedList.LinkedList(input);
        list = partition(list, 3);
        System.out.println(list.toString(" | "));
    }
}
