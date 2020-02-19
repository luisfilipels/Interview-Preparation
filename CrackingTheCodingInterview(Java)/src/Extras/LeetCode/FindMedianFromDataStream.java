package Extras.LeetCode;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private static class MedianFinder {

        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>((x1,x2) -> { // Will have at most one more element than upperHalf
            return x2-x1;
        }); // maxHeap

        PriorityQueue<Integer> upperHalf = new PriorityQueue<>(); // minHeap

        MedianFinder(){}

        void addNum(int num) {
            lowerHalf.add(num);  // This puts num in the correct position of lowerHalf

            upperHalf.offer(lowerHalf.poll()); // lowerHalf will have one extra element at top. To balance both halves, we add said element to upperHalf, in its correct position.

            if (lowerHalf.size() < upperHalf.size()) { // If instead of balancing, we unbalanced both halves, we add to lowerHalf the smallest element of upperHalf
                lowerHalf.offer(upperHalf.poll());
            }

        }

        double findMedian() {
            if ((lowerHalf.size() + upperHalf.size()) % 2 != 0) {
                return (double) lowerHalf.peek();
            } else {
                return ((double)lowerHalf.peek() + (double)upperHalf.peek())/2.0;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();

        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(2);
        finder.addNum(3);
        finder.addNum(4);
        finder.addNum(4);
        finder.addNum(5);

        System.out.println(finder.findMedian());
    }

}
