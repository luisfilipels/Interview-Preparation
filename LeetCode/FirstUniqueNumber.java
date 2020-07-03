package Extras.LeetCode;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FirstUniqueNumber {

    static class ListNode {
        int val;
        long count;
        ListNode next;

        ListNode (int val) {
            this.val = val;
            count = 1;
        }
    }

    // Less than optimal solution, but it's accepted :P
    /*
    We use a linked list, in which each node contains a value and a count. The linked list has a head node (where the
    linked list starts) and a tail node (where it ends). We also keep control of a "currentInList" pointer which allows
    O(1) access to the unique element.
     */
    static class FirstUnique {
        ListNode currentInList;
        ListNode tail;
        ListNode head;

        HashMap<Integer, ListNode> hash = new HashMap<>();

        public FirstUnique(int[] nums) {
            if (nums.length == 0) {
                return;
            }
            head = new ListNode(nums[0]);
            hash.put(nums[0], head);
            tail = head;
            // Add all remaining items into the LL.
            for (int i = 1; i < nums.length; i++) {
                if (!hash.containsKey(nums[i])) {
                    // If this is a new value, add it to the end of the list.
                    tail.next = new ListNode(nums[i]);
                    tail = tail.next;
                    hash.put(nums[i], tail);
                } else {
                    // Else, increment its count
                    hash.get(nums[i]).count++;
                }
            }
            currentInList = head;
            // Iterate through all elements of the LL until we find an element that occurred only once.
            while (currentInList != null && currentInList.count != 1) {
                currentInList = currentInList.next;
            }
            System.out.println("BREAK");
        }

        public int showFirstUnique() {
            if (currentInList != null) {
                return currentInList.val;
            } else {
                return -1;
            }
        }

        public void add(int value) {
            if (currentInList != null) {
                // If the current pointer is not null (which means the head and tail pointers have been set)
                if (!hash.containsKey(value)) {
                    // New element, so add it to the end of the list
                    tail.next = new ListNode(value);
                    tail = tail.next;
                    hash.put(value, tail);
                } else {
                    // Existing element,so increment its count, and move the currentInList pointer, if needed
                    hash.get(value).count++;
                    while (currentInList != null && currentInList.count != 1) {
                        currentInList = currentInList.next;
                    }
                }
            } else {
                // Head and tail pointers possibly not set.
                if (hash.containsKey(value)) {
                    // Head and tail pointers set, so increment count
                    hash.get(value).count++;
                } else {
                    if (tail == null) {
                        // Head and tail pointers not set. Add first node, and set them.
                        head = new ListNode(value);
                        hash.put(value, head);
                        tail = head;
                        currentInList = head;
                    } else {
                        // Head and tail pointers set, so create new node
                        tail.next = new ListNode(value);
                        hash.put(value, tail.next);
                        tail = tail.next;
                        currentInList = tail;
                    }
                }

            }
        }
    }



    public static void main(String[] args) throws Exception{
        ArrayList<Integer> numsStart = new ArrayList<>();
        File file = new File("newtxt.txt");
        String content;
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name());
        content = scanner.next();
        String [] tokens = content.split(",");
        for (String token : tokens) {
            numsStart.add(Integer.parseInt(token));
        }
        int [] arr = new int[numsStart.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numsStart.get(i);
        }
        FirstUnique u = new FirstUnique(arr);
        u.add(28);
        u.add(346);
        u.add(268);
        u.add(927);
        System.out.println(u.showFirstUnique());
    }

}
