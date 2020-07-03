package Extras.LeetCode;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            ListNode temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.val);
                sb.append(" -> ");
                temp =temp.next;
            }
            return sb.toString();
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode num1 = l1;
        ListNode num2 = l2;
        ListNode returnList = new ListNode(0);
        ListNode returnListHead = returnList;
        int carry = 0;
        while (num1 != null || num2 != null) {
            int num1number = num1 != null ? num1.val : 0;
            int num2number = num2 != null ? num2.val : 0;
            int sum = carry + num1number + num2number;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            returnListHead.val = sum;
            returnListHead.next = new ListNode(0);
            returnListHead = returnListHead.next;
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        if (carry == 1) {
            returnListHead.val = 1;
        } else {
            ListNode temp = returnListHead;
            returnListHead = returnList;
            while (returnListHead.next != temp) {
                returnListHead = returnListHead.next;
            }
            returnListHead.next = null;
        }
        return returnList;
    }

    public static void main(String[] args) {
        //ListNode h1 = new ListNode(9);
        //h1.next = new ListNode(9);
        //ListNode h2 = new ListNode(1);

        ListNode h1 = new ListNode(2);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(3);

        ListNode h2 = new ListNode(5);
        h2.next = new ListNode(6);
        h2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(h1, h2));
    }

}
