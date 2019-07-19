package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class SimplifyDIrectoryPath {

    public static String simplifyPath(String A) {
        ArrayList<String> queue = new ArrayList<>();
        char [] array = A.toCharArray();
        for (int i = 0; i < array.length;) {
            if (array[i] == '/') {
                StringBuilder current = new StringBuilder();
                i++;
                while (i <= array.length-1 && array[i] != '/') {
                    current.append(array[i]);
                    i++;
                }
                if (current.toString().equals("..")) {
                    try {
                        queue.remove(queue.size() - 1);
                    } catch (Exception ignored) {}
                } else if (current.toString().equals(".")) {
                    continue;
                } else {
                    if (!current.toString().equals("")) {
                        queue.add(current.toString());
                    }
                }
            }
        }
        if (queue.size() > 0) {
            StringBuilder returnString = new StringBuilder("/");
            for (int i = 0; i <= queue.size()-1; i++) {
                returnString.append(queue.get(i));
                if (i <= queue.size()-2) {
                    returnString.append("/");
                }
            }
            return returnString.toString();
        }

        return "/";
    }

    public static void main(String[] args) {
        String A = "/home/";
        //String A = "/a/./b/../../c/";
        //String A = "/a/..";
        //String A = "/a/../";
        //String A = "/../../../../../a";
        //String A = "/a/./b/./c/./d/";
        //String A = "/a/../.././../../.";
        //String A = "/a//b//c//////d";
        A = simplifyPath(A);
        System.out.println(A);
    }
}
