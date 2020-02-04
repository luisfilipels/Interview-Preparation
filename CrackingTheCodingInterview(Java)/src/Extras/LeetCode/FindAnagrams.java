package Extras.LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindAnagrams {

    private static List<Integer> findAnagrams(String s, String p) {
        if (p.length() == 0 || s.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        int n = p.length();
        int [] count = new int[26];
        int [] ref = new int[26];
        for (int i = 0; i < n; i++) {
            ref[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = n-1;
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            count[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count, ref)) {
            result.add(left);
        }
        while (right < s.length()-1) {
            count[s.charAt(left) - 'a']--;
            left++;
            right++;
            count[s.charAt(right) - 'a']++;
            if (Arrays.equals(count, ref)) {
                result.add(left);
            }
        }
        return result;
    }

    // First solution. Relatively fast, but consumes quite a bit of space. A linked list gets the idea right, but takes up unecessary space :P
    /*
    private static class ListNode {
        char val;
        int index;
        ListNode next;

        ListNode(char val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private static List<Integer> findAnagrams(String s, String p) {
        if (p.length() == 0) {
            return new ArrayList<>();
        }
        int sizeOfList = 0;
        int n = p.length();
        int [] count = new int[26];
        int [] ref = new int[26];
        for (int i = 0; i < n; i++) {
            ref[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        ListNode head = null, tail = null;
        for (int i = 0; i < s.length(); i++) {
            if (head != null) {
                if (sizeOfList < n) {
                    head.next = new ListNode(s.charAt(i), i);
                    head = head.next;
                    sizeOfList++;
                    count[s.charAt(i) - 'a']++;
                } else {
                    head.next = new ListNode(s.charAt(i), i);
                    head = head.next;
                    count[tail.val - 'a']--;
                    tail = tail.next;
                    count[s.charAt(i) - 'a']++;
                }
            } else {
                head = new ListNode(s.charAt(i), i);
                tail = head;
                sizeOfList++;
                count[s.charAt(i) - 'a']++;
            }
            if (Arrays.equals(count, ref)) {
                result.add(tail.index);
            }
        }
        return result;
    }*/


    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(findAnagrams(s, p));
    }

}
