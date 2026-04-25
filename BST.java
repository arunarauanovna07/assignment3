package assignment2;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public static class Entry<K, V> {
        private K key;
        private V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
    public void put(K key, V value) {
        root = put(root, key, value);
    }
    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; // обновление значения
        }
        return node;
    }
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.value;
    }
    private Node get(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node;
    }
    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node minNode = findMin(node.right); // два потомка: находим минимальный в правом поддереве
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = deleteMin(node.right);
            size--;
        }
        return node;
    }
    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
    public int size() {
        return size;
    }
    public Iterable<Entry<K, V>> iterator() {
        List<Entry<K, V>> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }
    private void inOrder(Node node, List<Entry<K, V>> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(new Entry<>(node.key, node.value));
        inOrder(node.right, list);
    }
}