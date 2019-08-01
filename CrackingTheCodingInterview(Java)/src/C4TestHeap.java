public class C4TestHeap {

    public static void main(String[] args) {
        C4MinIntHeap heap = new C4MinIntHeap();

        heap.add(5);
        heap.add(3);
        heap.add(6);
        heap.add(1);
        heap.add(2);
        heap.add(4);

        try {
            while (true) {
                System.out.println(heap.removeMin());
            }
        } catch (Exception ignored) {}
    }

}
