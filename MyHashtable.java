package assignment2;
public class MyHashtable<K, V> {
    private static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;
        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M;
    private int size;
    @SuppressWarnings("unchecked")
    public MyHashtable() {
        this(11);
    }
    @SuppressWarnings("unchecked")
    public MyHashtable(int M) {
        this.M = M;
        chainArray = (HashNode<K, V>[]) new HashNode[M];
        size = 0;
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> curr = chainArray[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> curr = chainArray[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> curr = chainArray[index];
        HashNode<K, V> prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> curr = chainArray[i];
            while (curr != null) {
                if (curr.value.equals(value)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }
    public int size() {
        return size;
    }
    // Новый публичный метод для получения размеров корзин
    public int[] bucketSizes() {
        int[] sizes = new int[M];
        for (int i = 0; i < M; i++) {
            HashNode<K, V> curr = chainArray[i];
            int count = 0;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            sizes[i] = count;
        }
        return sizes;
    }
}
