# Java Queue Implementation

This repository contains a simple implementation of a **Queue** data structure in Java using a linked list approach. The `Queue` class is built completely from scratch without using Java's built-in `Queue`, making it perfect for understanding how queues work internally.

---

## Package

```
Queue.src
```

---

## Features

- **Enqueue** - Add elements to the back of the queue
- **Dequeue** - Remove and return the front element
- **Peek** - View the front element without removing it
- **Check if empty** - Determine if the queue is empty
- **Get size** - Get the current number of elements in the queue
- **Generic implementation** - Works with any data type

---

## Usage

### Full Example

```java
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
```

---

## API Reference

| Method | Description | Time Complexity |
|--------|-------------|-----------------|
| enqueue(item data) | Adds an item to the rear of the queue | O(1) |
| dequeue() | Removes and returns the front item | O(1) |
| peek() | Returns the front item without removing it | O(1) |
| isEmpty() | Returns true if the queue is empty | O(1) |
| size() | Returns the number of items in the queue | O(1) |


---

## Queue Properties

- **FIFO (First In, First Out)**: The first element added is the first one to be removed
- **Linked List Based**: Uses an internal linked list for efficient O(1) insertions and deletions
- **Generic**: Can store any data type using Java generics

---

## Requirements

- Java Development Kit (JDK) 8 or higher

