package Extras.LeetCode;

public class IntersectionOfTwoLL {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
            next = null;
        }
    }

    // Original solution. Performs better.
    private static ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        if (headA == headB) return headA;
        ListNode pointA = headA;
        ListNode pointB = headB;
        boolean aEnded = false;
        boolean bEnded = false;
        while (true){
            pointA = pointA.next;
            if (pointA == null){
                if (!aEnded) {
                    pointA = headB;
                    aEnded = true;
                } else {
                    return null;
                }
            }
            pointB = pointB.next;
            if (pointB == null) {
                if (!bEnded) {
                    pointB = headA;
                    bEnded = true;
                } else {
                    return null;
                }
            }
            if (pointA == pointB) {
                return pointA;
            }
        }
    }

    // Alternative solution. Identical to C2Q7 of Cracking the Coding Interview.
    static ListNode findIntersect (ListNode h1, ListNode h2) {
        int size1 = 0, size2 = 0;

        ListNode temp = h1;
        while (temp != null) {
            size1++;
            temp = temp.next;
        }

        temp = h2;
        while (temp != null) {
            size2++;
            temp = temp.next;
        }

        int dif;
        if (size1 < size2) {
            temp = h1;
            h1 = h2;
            h2 = temp;
            dif = size2 - size1;
        } else {
            dif = size1 - size2;
        }

        temp = h1;
        ListNode temp2 = h2;

        for (int i = 0; i < dif; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            if (temp == temp2) {
                return temp;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        headB.next.next = new ListNode(8);
        //headB.next.next.next = headA.next.next;
        System.out.println(getIntersectionNode(headA, headB).val);

    }

}
