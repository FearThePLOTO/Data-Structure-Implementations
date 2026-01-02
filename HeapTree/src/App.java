public class App {
    public static void main(String[] args) {
        // min heap demo
        System.out.println("--- Min Heap ---");
        HeapTree minHeap = HeapTree.minHeap();
        int[] vals = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35};
        System.out.print("Inserting: ");
        for (int v : vals) {
            System.out.print(v + " ");
            minHeap.insert(v);
        }
        System.out.println("\n" + minHeap);
        System.out.println("isValid: " + minHeap.isValid());
        System.out.println("peek: " + minHeap.peek());
        System.out.println("extract: " + minHeap.extract());
        System.out.println("after extract: " + minHeap);

        // max heap demo
        System.out.println("\n--- Max Heap ---");
        HeapTree maxHeap = HeapTree.maxHeap();
        int[] vals2 = {10, 20, 15, 30, 40, 25, 50, 5, 35, 45};
        System.out.print("Inserting: ");
        for (int v : vals2) {
            System.out.print(v + " ");
            maxHeap.insert(v);
        }
        System.out.println("\n" + maxHeap);
        System.out.println("isValid: " + maxHeap.isValid());
        System.out.println("peek: " + maxHeap.peek());
        System.out.println("extract: " + maxHeap.extract());
        System.out.println("after extract: " + maxHeap);

        // remove demo
        System.out.println("\n--- Remove Demo ---");
        HeapTree heap = HeapTree.minHeap();
        heap.insertAll(50, 30, 70, 20, 40, 60, 80, 20, 30, 40);
        System.out.println("heap: " + heap);
        System.out.println("contains 30: " + heap.contains(30));
        System.out.println("count 20: " + heap.count(20));
        System.out.println("remove 20: " + heap.remove(20));
        System.out.println("after remove: " + heap);
        System.out.println("isValid: " + heap.isValid());

        // build from array
        System.out.println("\n--- Build from Array ---");
        int[] arr = {45, 30, 60, 15, 50, 20, 70, 10, 40, 55};
        System.out.println("array: [45, 30, 60, 15, 50, 20, 70, 10, 40, 55]");
        System.out.println("minHeap: " + HeapTree.minHeap(arr));
        System.out.println("maxHeap: " + HeapTree.maxHeap(arr));

        // sort demo
        System.out.println("\n--- Sort Demo ---");
        HeapTree sortHeap = HeapTree.minHeap();
        sortHeap.insertAll(85, 25, 70, 15, 50, 30, 60, 10, 40, 45);
        int[] sorted = sortHeap.sort();
        System.out.print("sorted: [");
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + (i < sorted.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        // merge demo
        System.out.println("\n--- Merge Demo ---");
        HeapTree h1 = HeapTree.minHeap();
        h1.insertAll(10, 20, 30);
        HeapTree h2 = HeapTree.minHeap();
        h2.insertAll(15, 25, 35);
        System.out.println("h1: " + h1);
        System.out.println("h2: " + h2);
        h1.merge(h2);
        System.out.println("after merge: " + h1);

        // tree print
        System.out.println("\n--- Tree Structure ---");
        HeapTree treeHeap = HeapTree.minHeap();
        treeHeap.insertAll(10, 20, 5, 15, 30, 25, 40);
        treeHeap.printTree();

        // extract all (sorting)
        System.out.println("\n--- Extract All (Sorted) ---");
        HeapTree extractHeap = HeapTree.minHeap();
        extractHeap.insertAll(45, 12, 78, 34, 56, 89, 23, 67);
        System.out.println("heap: " + extractHeap);
        System.out.print("sorted: ");
        while (!extractHeap.isEmpty()) {
            System.out.print(extractHeap.extract() + " ");
        }
        System.out.println();

        // priority queue simulation
        System.out.println("\n--- Priority Queue (Min = High Priority) ---");
        HeapTree pq = HeapTree.minHeap();
        pq.insertAll(3, 1, 4, 1, 5, 9, 2, 6);
        System.out.print("processing: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.extract() + " ");
        }
        System.out.println();

        System.out.println("\n=== DONE ===");
    }
}

