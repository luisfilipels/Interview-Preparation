public class C2Q2 {

    public static C2LinkedList.Node kThToLast (C2LinkedList.LinkedList list, int k) {
        C2LinkedList.Node forward = list.head;
        C2LinkedList.Node backward = list.head;
        int i = 0;
        while (forward.next != null) {
            forward = forward.next;
            i++;
            if (i > k) {
                backward = backward.next;
            }
        }
        return backward;
    }

    /*
    // Solução trivial, trapaça, feia, não-estilosa, blablabla. Não utilizar '--
    public static C2LinkedList.Node kThToLast (C2LinkedList.LinkedList list, int k) {
        C2LinkedList.Node temp = list.head;
        int size = list.size();
        int j = 0;
        while (temp.next != null && j < size - k) {
            temp = temp.next;
            j++;
        }
        return temp;
    }*/

    public static void main(String[] args) {
        int [] input = {1, 2, 3, 4, 5};
        C2LinkedList.LinkedList list = new C2LinkedList.LinkedList(input);
        System.out.println(kThToLast(list, 1).data);

    }
}
