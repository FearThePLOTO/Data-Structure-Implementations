public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<Integer>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element is: " + queue.peek()); // Should print 10
        System.out.println("Queue size is: " + queue.size());   // Should print 3

        System.out.println("Dequeued: " + queue.dequeue());      // Should print 10
        System.out.println("Front element is: " + queue.peek()); // Should print 20
        System.out.println("Queue size is: " + queue.size());   // Should print 2
    }
}
