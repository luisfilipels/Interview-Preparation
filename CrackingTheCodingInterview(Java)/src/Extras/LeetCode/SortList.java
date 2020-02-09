package Extras.LeetCode;

import java.util.Arrays;

public class SortList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            ListNode ptr = this;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (ptr != null) {
                sb.append(ptr.val);
                sb.append(", ");
                ptr = ptr.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private static ListNode [] separate (ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode [] {head, null};
        }

        ListNode toEnd = head.next;
        ListNode toMid = head;

        while (toEnd != null) {
            toEnd = toEnd.next;
            if (toEnd != null) {
                toEnd = toEnd.next;
                toMid = toMid.next;
            }
        }
        ListNode [] parts = new ListNode[] {head, toMid.next};
        toMid.next = null;
        return parts;
    }

    private static ListNode mergeSort (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode [] parts = separate(head);
        ListNode left = parts[0];
        ListNode right = parts[1];

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode newHead;
        ListNode newTail;

        if (left == null) return right;
        if (right == null) return left;

        if (left.val < right.val) {
            newHead = left;
            left = left.next;
        } else {
            newHead = right;
            right = right.next;
        }

        newTail = newHead;

        while (left != null && right != null) {
            if (left.val == right.val) {
                newTail.next = left;
                ListNode bkp = left;
                left = left.next;
                bkp.next = right;
                right = right.next;
                bkp = bkp.next;
                bkp.next = null;
                newTail = bkp;
            } else if (left.val < right.val) {
                newTail.next = left;
                left = left.next;
                newTail.next.next = null;
                newTail = newTail.next;
            } else {
                newTail.next = right;
                right = right.next;
                newTail.next.next = null;
                newTail = newTail.next;
            }
        }

        if (left == null && right == null) {
            return newHead;
        } else if (left == null) {
            newTail.next = right;
        } else {
            newTail.next = left;
        }
        return newHead;
    }

    private static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode listFromArray (int [] arr) {
        ListNode head;
        ListNode tail;

        head = new ListNode(arr[0]);
        tail = head;

        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {2,1,4,5,1,0,3,4,6,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ListNode l1 = listFromArray(new int[] {2,1,4,5,1,0,3,4,6,8});
        System.out.println(sortList(l1));
        //ListNode l2 = listFromArray(new int[] {1,2,2,5});
        //System.out.println(merge(l1, l2));
    }

}
