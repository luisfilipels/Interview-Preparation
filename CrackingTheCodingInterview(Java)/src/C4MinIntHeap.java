import java.util.Arrays;

public class C4MinIntHeap {

    int [] items = new int[1];
    int tam = 0;

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
        return getLeftChildIndex(index) < tam;
    }

    private boolean hasRightChild (int index) {
        return getRightChildIndex(index) < tam;
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
        if (tam == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    public int removeMin () {
        if (tam == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[tam -1];
        tam--;
        heapifyDown();
        return item;
    }

    public void add (int item) {
        ensureExtraCapacity();
        items[tam] = item;
        tam++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = tam -1;
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
