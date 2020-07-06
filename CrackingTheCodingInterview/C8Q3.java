public class C8Q3 {

    static boolean magicIndexNonDistinct (int [] array, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return true;
        }
        if (start >= end) {
            return false;
        }
        if (array[mid] > mid) {
            // Se array[mid] > mid, sabemos que um número mágico pode ainda estar logo depois do número atual (pois pode
            // estar repetido). Lógica semelhante para o else.
            return magicIndexNonDistinct(array, start, Math.min(mid - 1, array[mid]));
        } else {
            return magicIndexNonDistinct(array, Math.max(mid + 1, array[mid]), end);
        }
    }

    static boolean magicIndexDistinct (int [] array, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return true;
        }
        if (start >= end) {
            return false;
        }
        if (array[mid] > mid) {
            return magicIndexDistinct(array, start, mid - 1);
        } else {
            return magicIndexDistinct(array, mid, end - 1);
        }
    }

    public static void main(String[] args) {
        int [] array = {4, 5, 6, 7, 8, 9, 10};
        System.out.println(magicIndexDistinct(array, 0, array.length-1));
    }

}
