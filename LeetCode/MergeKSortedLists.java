package Extras.LeetCode;

public class MergeKSortedLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while (temp != null) {
                sb.append(temp.val).append("->");
                temp = temp.next;
            }
            return sb.toString();
        }
    }

    private static ListNode mergeKLists (ListNode[] lists) {
        // The basic idea of this algorithm is to merge each list 2 by two, feeding the list from the previous merge into
        // the next. The main list is the one that will persist between merges, and a pointer to the next list is used
        // to keep track of the nodes from the second list that have already been "consumed" and inserted into the main
        // list. The pointer to the second list will always be the next node to be inserted into the main list.
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode dummy = new ListNode(-1); // Create a dummy node at the start. Useful because there needs to be a node previous to the main node.
        dummy.next = lists[0];
        ListNode main = lists[0];
        ListNode prev = dummy;
        int i = 1; // To merge the second list [1] into the first [0].
        while (i < lists.length) {
            ListNode second = lists[i];
            if (dummy.next == null && second != null) { // If the first list is null while the second is not null...
                dummy.next = second;                    // swap both lists and proceed with the algorithm.
                prev = dummy;
                main = dummy.next;
                i++;
                continue;
            }
            while (second != null) { // While the last node of the second list hasn't been consumed.
                ListNode temp;
                if (main.val == second.val) {
                    // In this case, we simply insert the current node of the second list into the first list as its next
                    // element after the main pointer.
                    temp = second.next;
                    second.next = main.next;
                    main.next = second;
                    second = temp;
                    prev = main;
                    main = main.next;
                } else if (main.val > second.val) {
                    // In this case, we insert the current node of the second list as the next node of the node previous
                    // to the main node of the first list.
                    prev.next = second;
                    temp = second.next;
                    second.next = main;
                    second = temp;
                    prev = prev.next;
                } else {
                    // In this case, we start by moving the main and previous nodes forward. Useful in cases such as:
                    // i ->i (should be moved to this position)
                    // 1 1 1 2
                    // j
                    // 3 3 4 5
                    // i is the main node, and j is the second. After this is done, we insert the current node of the
                    // second list as the next node of the main node.
                    while (main.next != null && main.next.val < second.val) {
                        main = main.next;
                        prev = prev.next;
                    }
                    temp = second.next;
                    second.next = main.next;
                    main.next = second;
                    second = temp;
                    prev = main;
                    main = main.next;
                }
            }
            main = dummy.next;
            prev = dummy;
            i++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode [] listNodes = new ListNode[3];
        listNodes[1] = new ListNode(2);
        listNodes[2] = new ListNode(-3);
        listNodes[2].next = new ListNode(-2);
        listNodes[2].next.next = new ListNode(1);
        /*ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        listNodes[0] = node1;
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        listNodes[1] = node2;
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        listNodes[2] = node3;*/

        ListNode temp = mergeKLists(listNodes);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
