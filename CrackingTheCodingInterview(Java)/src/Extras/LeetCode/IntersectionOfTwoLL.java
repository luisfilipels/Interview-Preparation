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
