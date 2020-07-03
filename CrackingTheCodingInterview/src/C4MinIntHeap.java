import java.util.Arrays;

public class C4MinIntHeap {

    int [] items = new int[1];
    int size = 0;

    // https://www.youtube.com/watch?v=t0Cq6tVNRBA
    // Parent: ceil((index - 1) / 2)
    // Left Child: index * 2 + 1
    // Right Child: index * 2 + 2

    private int leftChild (int index) {
        return items[getLeftChildIndex(index)];
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChild (int index) {
        return items[getRightChildIndex(index)];
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int parent (int index) {
        return items[getParentIndex(index)];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeftChild (int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild (int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent (int index) {
        return getParentIndex(index) >= 0;
    }

    private void swap (int one, int two) {
        int temp = items[one];
        items[one] = items[two];
        items[two] = temp;
    }

    private void ensureExtraCapacity () {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    public int removeMin () {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size -1];
        size--;
        heapifyDown();
        return item;
    }

    public void add (int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size -1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

}
