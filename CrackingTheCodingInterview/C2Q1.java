import java.util.HashSet;

public class C2Q1 {

    public static void removeDups(C2LinkedList.LinkedList list) {
        C2LinkedList.Node current = list.head;
        while (current.next != null) {
            C2LinkedList.Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {

        C2LinkedList.LinkedList list = new C2LinkedList.LinkedList();
        list.append(3);
        list.append(2);
        list.append(6);
        list.append(2);
        list.append(6);
        list.append(2);
        list.append(1);
        list.append(2);
        list.append(2);
        removeDups(list);
        System.out.println(list.toString());


    }

}
