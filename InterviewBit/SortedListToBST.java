package Extras.InterviewBit;

public class SortedListToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {val = x; next = null;}
    }

    static public TreeNode sortedListToBST(ListNode a) {
        ListNode temp = a;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int [] array = new int[size];
        temp = a;
        int i = 0;
        while (temp != null && i < size) {
            array[i] = temp.val;
            i++;
            temp = temp.next;
        }
        return listToBst(0, size-1, array);
    }

    static TreeNode listToBst (int start, int end, int [] array) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = listToBst(start, mid - 1, array);
        root.right = listToBst(mid + 1, end, array);
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        TreeNode tree = sortedListToBST(root);
        System.out.println(1);
    }

}
