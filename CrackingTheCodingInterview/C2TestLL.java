public class C2TestLL {

    public static void main(String[] args) {
        C2LinkedList.LinkedList list = new C2LinkedList.LinkedList();
        list.append(0);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        System.out.println(list.toString(" | "));
        list.remove(3);
        System.out.println(list.toString(" | "));
        list.deleteNode(0);
        System.out.println(list.toString(" | "));
        list.remove(1);
        System.out.println(list.toString(" | "));

    }

}
