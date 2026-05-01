package assignment2;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(" MyHashtable ");
        MyHashtable<MyTestingClass, Student> table = new MyHashtable<>(11);
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String name = "Name" + random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(id, name);
            Student student = new Student("Student_" + id, random.nextDouble() * 4.0);
            table.put(key, student);
        }
        int[] bucketSizes = table.bucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.printf("Bucket %2d : %d elements%n", i, bucketSizes[i]);
        }
        System.out.println("Total size: " + table.size());
        System.out.println("\n BST ");
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(7, "seven");
        tree.put(1, "one");
        tree.put(4, "four");
        System.out.println("Size = " + tree.size());
        for (BST.Entry<Integer, String> entry : tree.iterator()) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
        tree.delete(3);
        System.out.println("After delete 3:");
        for (BST.Entry<Integer, String> entry : tree.iterator()) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
        System.out.println("Size = " + tree.size());
    }
}