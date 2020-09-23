public class DeleteNodeInLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        ListNode temp = node;

        while (temp.next.next != null) {
            int next = temp.next.val;
            temp.val = next;
            temp = temp.next;
        }
        int next = temp.next.val;
        temp.val = next;
        temp.next = null;
    }

}
