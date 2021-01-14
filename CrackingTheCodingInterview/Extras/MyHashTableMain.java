package Extras;

import java.util.ArrayList;
import java.util.Objects;

public class MyHashTableMain {

    static class EntryNode<K, V> {
        private K key;
        private V value;
        private EntryNode<K, V> next;

        EntryNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static class MyHashTable<K, V> {
        EntryNode<K, V> [] table;
        int tableSize;

        MyHashTable(int tableSize) {
            this.tableSize = tableSize;
            table = new EntryNode[tableSize];
        }

        int getHash (K key) {
            return Objects.hashCode(key) % tableSize;
        }

        void put (K key, V value) {
            int hash = getHash(key);

            if (table[hash] == null) {
                table[hash] = new EntryNode<>(key, value);
            } else {
                System.out.println("Collision!");
                EntryNode<K, V> temp = table[hash];
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new EntryNode<>(key, value);
            }
        }

        V get (K key) {
            int hash = getHash(key);

            if (table[hash] == null) {
                return null;
            }
            EntryNode<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashTable<Integer, String> hash = new MyHashTable<>(10);

        for (int i = 0; i < 100; i++) {
            hash.put(i, Integer.toBinaryString(i));
        }

        //hash.put(Integer.toString(1), Integer.toBinaryString(1));

        System.out.println(hash.get(55));
    }

}
