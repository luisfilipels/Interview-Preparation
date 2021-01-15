import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DesignHashMap {

    class MyHashMap {

        class Entry {
            int key, value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        final int CAPACITY = 5000;

        List<Entry>[] places = new LinkedList[CAPACITY];

        /** Initialize your data structure here. */
        public MyHashMap() {
            for (int i = 0; i < CAPACITY; i++) {
                places[i] = new LinkedList<>();
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = Objects.hashCode(key) % CAPACITY;

            for (Entry e : places[hash]) {
                if (e.key == key) {
                    e.value = value;
                    return;
                }
            }

            places[hash].add(new Entry(key, value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = Objects.hashCode(key) % CAPACITY;

            for (Entry e : places[hash]) {
                if (e.key == key) {
                    return e.value;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = Objects.hashCode(key) % CAPACITY;
            Entry toRemove = null;

            for (Entry e : places[hash]) {
                if (e.key == key) {
                    toRemove = e;
                    break;
                }
            }
            if (toRemove != null) places[hash].remove(toRemove);
        }
    }

}
