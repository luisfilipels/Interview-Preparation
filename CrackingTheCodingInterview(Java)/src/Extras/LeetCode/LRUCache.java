package Extras.LeetCode;

import java.util.HashMap;

/*
    Accepted on my first try, with great performance! :D

    This implementation utilizes a doubly linked list with a HashMap. Basically, the oldest value occupies the tail of
    the list, while the most recently used value occupies its head. If we try to get (or put a value that is already in
    our cache), we set it as the new head of the linked list, doing all the necessary pointer updates. If we insert a new
    value into the cache, with the cache full, we add the new value as the new head, and move the tail pointer forward.

     */

public class LRUCache {

    static class ListNode {
        int val;
        int key; // Used when we want to remove a node from the linked list by getting it from the hashmap.


        ListNode next;
        ListNode previous;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class Cache {

        HashMap<Integer, ListNode> hashMap = new HashMap<>();

        ListNode head;
        ListNode tail;

        int capacity;
        int amountInCache;

        Cache(int capacity) {
            this.capacity = capacity;
        }

        int get(int key) {
            if (!hashMap.containsKey(key)) {
                return -1;
            }
            ListNode getNode = hashMap.get(key);
            if (getNode == head) {  // If the key we get is at the head, we simply return the value, as no pointer update is needed.
                return getNode.val;
            } else if (getNode == tail) {  // If it's at the tail...
                tail = tail.next;          // simply move the tail pointer...
                tail.previous = null;
                head.next = getNode;       // and set the new head as the tail.
                getNode.previous = head;
                getNode.next = null;
                head = getNode;
                return getNode.val;
            } else {                        // If it's somewhere between head and tail...
                head.next = getNode;        // set the new head as the node we got...
                getNode.previous.next = getNode.next;               // make the node previous to the one we got point to the one after.
                getNode.previous.next.previous = getNode.previous;  // Do the same for its previous
                getNode.previous = head;
                getNode.next = null;
                head = getNode;
                return getNode.val;
            }
        }

        void put (int key, int value) {
            if (!hashMap.containsKey(key)) {
                if (amountInCache < capacity) {
                    amountInCache++;
                    if (head == null) {
                        head = new ListNode(key, value);
                        head.previous = null;
                        tail = head;
                        hashMap.put(key, head);
                    } else {
                        head.next = new ListNode(key, value);
                        head.next.previous = head;
                        head = head.next;
                        hashMap.put(key, head);
                    }
                } else {
                    hashMap.remove(tail.key);   // If the cache is full, first remove from our HashMap the oldest node.
                    if (capacity == 1) {        // Border case.
                        head.next = new ListNode(key,value);
                        head = head.next;
                        head.previous = null;
                        tail = head;
                        hashMap.put(key,head);
                        return;
                    }
                    tail.next.previous = null;
                    tail = tail.next;
                    head.next = new ListNode(key, value);
                    head.next.previous = head;
                    head = head.next;
                    hashMap.put(key, head);
                }
            } else {
                hashMap.get(key).val = value;
                get(key); // The get function will update the position of the node we got in the linked list.
            }
        }

    }

    public static void main(String[] args) {

        /*Cache cache = new Cache(1);
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));*/

        Cache cache = new Cache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));


        /*Cache cache = new Cache(4);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(1));
        cache.put(3,5);
        System.out.println(cache.get(2));
        cache.put(6,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));*/
    }

}
