import java.util.HashSet;

public class C2Q7 {

    public static boolean intersect (C2LinkedList.LinkedList list1, C2LinkedList.LinkedList list2) {
        C2LinkedList.Node lastOne = list1.head;
        while (lastOne.next != null) {
            lastOne = lastOne.next;
        }
        C2LinkedList.Node lastTwo = list2.head;
        while (lastTwo.next != null) {
            lastTwo = lastTwo.next;
        }
        return lastOne == lastTwo;
    }

    public static boolean intersectWithHash(C2LinkedList.LinkedList list1, C2LinkedList.LinkedList list2) {
        C2LinkedList.Node temp = list1.head;
        HashSet<C2LinkedList.Node> hashSet = new HashSet<>();
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }
        temp = list2.head;
        while (temp != null) {
            if (hashSet.contains(temp)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        C2LinkedList.LinkedList list1 = new C2LinkedList.LinkedList(new int[] {1, 2, 3, 4, 5});
        C2LinkedList.LinkedList list2 = new C2LinkedList.LinkedList(new int [] {1, 2});
        list2.head.next.next = list1.head.next.next;
        System.out.println(intersectWithHash(list1, list2));
        System.out.println(intersect(list1, list2));
    }
}
