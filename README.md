# Java Data Structures

This repository contains implementations of fundamental **data structures** in Java. Each data structure is built from scratch without relying on built-in Java collections, making this repo a practical resource for understanding how these structures work internally.

---

## Project Structure

```
Data-Structure-Implementations/
|
├── List/
|   └── src/
|       └── List.java
|
├── LinkedList/
|   └── src/
|       └── LinkedList.java
|
├── Queue/
|   └── src/
|       └── Queue.java
|
├── Stack/
|   └── src/
|       └── Stack.java
|
└── HeapTree/
    └── src/
        └──  HeapTree.java
```

---

## Implemented Data Structures

### List

A custom dynamic array implementation similar to Java's `ArrayList`.

**Features:**
- Dynamic resizing when capacity is reached
- Add elements at the end of the list
- Get and set elements by index
- Remove elements by index (with automatic shifting)
- Check if empty or full
- Clear all elements
- Custom `toString` method for easy printing

### LinkedList

A custom singly linked list implementation.

**Features:**
- Insert elements at the end of the list
- Delete elements by value
- Access elements by index
- Modify elements by index
- Search for an element
- Check if the list is empty
- Get current size
- Clear all elements
- Display all elements in a readable format

### Queue

A custom queue implementation using a linked list approach.

**Features:**
- Enqueue - Add elements to the back of the queue
- Dequeue - Remove and return the front element
- Peek - View the front element without removing it
- Check if empty
- Get size
- Generic implementation

### Stack

A custom stack implementation using an array-based approach.

**Features:**
- Push - Add elements to the top of the stack
- Pop - Remove and return the top element
- Peek - View the top element without removing it
- Check if empty or full
- Get size
- Generic implementation

### HeapTree

A complete binary tree implementation supporting both Min Heap and Max Heap operations.

**Features:**
- Min Heap and Max Heap support
- Array-based implementation for efficient operations
- Insert, extract, peek operations
- Remove specific values
- Contains and count operations
- Heap property validation
- Sort via heap sort
- Merge two heaps
- Tree visualization

---

*Contributions and improvements are welcome!*

