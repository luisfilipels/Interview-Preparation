import java.util.HashSet;
import java.util.Stack;

public class ReorderList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    private static void reorderList(ListNode head) {
        if (head == null) return;

        HashSet<ListNode> addedToLL = new HashSet<>();
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode runner = dummy;

        while (true) {
            if (addedToLL.contains(head)) break;
            runner.next = head;
            addedToLL.add(head);
            head = head.next;
            runner = runner.next;

            if (addedToLL.contains(stack.peek())) break;
            runner.next = stack.pop();
            addedToLL.add(runner.next);
            runner = runner.next;
        }
        runner.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);

        System.out.println(head.val);
    }



}
