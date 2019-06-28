public class C2Q5 {

    public static C2LinkedList.LinkedList sumLists (C2LinkedList.LinkedList list1, C2LinkedList.LinkedList list2) {
        int size1 = list1.size();
        int size2 = list2.size();
        int num1 = 0;
        int num2 = 0;
        C2LinkedList.Node temp = list1.head;
        for (int i = 0; i <= size1; i++) {
            num1 += temp.data * Math.pow(10, i);
            temp = temp.next;
        }
        temp = list2.head;
        for (int i = 0; i <= size2; i++) {
            num2 += temp.data * Math.pow(10, i);
            temp = temp.next;
        }
        num1 += num2;
        C2LinkedList.LinkedList returnList = new C2LinkedList.LinkedList();
        while (num1 > 1) {
            returnList.append(num1 % 10);
            num1 /= 10;
        }
        return returnList;

    }

    public static void main(String[] args) {
        int [] input1  = {7, 1, 6};
        int [] input2 = {5};
        C2LinkedList.LinkedList list1 = new C2LinkedList.LinkedList(input1);
        C2LinkedList.LinkedList list2 = new C2LinkedList.LinkedList(input2);
        System.out.println(sumLists(list1, list2).toString());
    }
}
