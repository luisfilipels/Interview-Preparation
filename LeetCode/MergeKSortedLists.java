package Extras.LeetCode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) { val = x; }

        ListNode(){}

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

    /*private static ListNode mergeKLists (ListNode[] lists) {
        // This algorithm follows the brute force approach
        // The basic idea of this algorithm is to merge each list two by two, feeding the list from the previous merge into
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
    }*/

    static private ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode handler = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }
        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }
        return head.next;
    }

    // This algorithm also follows the brute force approach, but has cleaner code. Takes approximately the same time
    // as the previous solution, but saves some memory.
    private static ListNode mergeKLists2 (ListNode [] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode dummy = new ListNode();

        for (int i = 1; i < lists.length; i++) {
            dummy.next = mergeTwoLists(lists[i], lists[i-1]);
            lists[i] = dummy.next;
        }

        return dummy.next;
    }

    // Approach that uses a priority queue.
    // With a priority queue sorted by the values of each ListNode's value, we can insert the heads of each listnode
    // in the array into the priority queue, and when we call the poll method, we immediately get the listnode with the
    // smallest value, which we can then add to our Linked List that is to be returned.
    private static ListNode mergeKLists (ListNode [] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>( (x1, x2) -> {
            return x1.val - x2.val;
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode returnNode = new ListNode();
        ListNode runner = returnNode;

        while (!queue.isEmpty()) {
            ListNode current = queue.poll();
            runner.next = current;
            runner = runner.next;
            if (current.next != null) {
                queue.add(current.next);
            }
        }
        return returnNode.next;
    }

    public static void main(String[] args) {
        ListNode [] listNodes = new ListNode[3];

        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);

        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);

        System.out.println(mergeKLists(listNodes));

        /*listNodes[1] = new ListNode(2);
        listNodes[2] = new ListNode(-3);
        listNodes[2].next = new ListNode(-2);
        listNodes[2].next.next = new ListNode(1);
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        listNodes[0] = node1;
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        listNodes[1] = node2;
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        listNodes[2] = node3;

        ListNode temp = mergeKLists(listNodes);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }*/
    }

}
