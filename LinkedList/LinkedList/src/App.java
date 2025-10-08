// package LinkedListImp.src;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();

        System.out.println("=== Testing insert() ===");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display(); // Expected: 10 -> 20 -> 30 -> null

        System.out.println("\n=== Testing size() ===");
        System.out.println("Size: " + list.size()); // Expected: 3
        System.out.println("\n=== Testing get() ===");
        System.out.println("Element at index 0: " + list.get(0)); // Expected: 10
        System.out.println("Element at index 1: " + list.get(1)); // Expected: 20
        System.out.println("Element at index 2: " + list.get(2)); // Expected: 30
        // Uncomment to test exception: list.get(5);

        System.out.println("\n=== Testing set() ===");
        list.set(1, 99); // Change 20 to 99
        list.display(); // Expected: 10 -> 99 -> 30 -> null

        System.out.println("\n=== Testing contains() ===");
        System.out.println("Contains 99? " + list.contains(99)); // Expected: true
        System.out.println("Contains 20? " + list.contains(20)); // Expected: false

        System.out.println("\n=== Testing indexOf() ===");
        System.out.println("Index of 99: " + list.indexOf(99)); // Expected: 1
        System.out.println("Index of 50: " + list.indexOf(50)); // Expected: -1

        System.out.println("\n=== Testing delete() ===");
        list.delete(10); // Delete head
        list.display(); // Expected: 99 -> 30 -> null
        list.delete(30); // Delete tail
        list.display(); // Expected: 99 -> null
        list.delete(99); // Delete remaining element
        list.display(); // Expected: null
        list.delete(999); // Try deleting non-existent element (should do nothing)

        System.out.println("\n=== Testing isEmpty() ===");
        System.out.println("List empty? " + list.isEmpty()); // Expected: true

        System.out.println("\n=== Testing clear() ===");
        list.insert(5);
        list.insert(15);
        list.insert(25);
        list.display(); // Expected: 5 -> 15 -> 25 -> null
        list.clear();
        list.display(); // Expected: null
        System.out.println("List empty after clear? " + list.isEmpty()); // Expected: true
        System.out.println("\n=== All tests completed successfully! ===");
    }
}
