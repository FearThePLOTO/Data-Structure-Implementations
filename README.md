# Java Data Structures

This repository contains implementations of fundamental **data structures** in Java. Each data structure is built from scratch without relying on built-in Java collections.

---

## Project Structure

```
Data-Structure-Implementations/
|
├── List/
|   └── src/
|       ├── List.java
|       └── App.java
|
├── LinkedList/
|   └── src/
|       ├── LinkedList.java
|       └── App.java
|
├── Queue/
|   └── src/
|       ├── Queue.java
|       └── App.java
|
├── Stack/
|   └── src/
|       ├── Stack.java
|       └── App.java
|
├── HeapTree/
|   └── src/
|       ├── HeapTree.java
|       └── App.java
|
└── BSTree/
    └── src/
        ├── BinarySearchTree.java
        └── App.java
```

---

## Implemented Data Structures

### List

A custom dynamic array implementation similar to Java's ArrayList.

**Features:**
- Dynamic resizing when capacity is reached
- Add elements at the end of the list
- Get and set elements by index
- Remove elements by index with automatic shifting
- Check if empty or full
- Clear all elements
- Display all elements in readable format

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
- Display all elements in readable format

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
- Insert single or multiple values
- Extract root element
- Peek at root without removing
- Remove specific values from the heap
- Check if value exists and count occurrences
- Validate heap property
- Convert to sorted array via heap sort
- Merge two heaps of same type
- Tree structure visualization
- Auto-resizing when capacity is exceeded

### BinarySearchTree

A complete Binary Search Tree implementation with full functionality.

**Features:**
- Insert single or multiple keys
- Search for keys in the tree
- Delete keys (handles leaf nodes, single child, and two children cases)
- Get minimum and maximum values
- Inorder traversal returns sorted array
- Preorder traversal for root-left-right order
- Postorder traversal for left-right-root order
- Get tree height
- Count leaf nodes
- Calculate depth of specific keys
- Count nodes at a given level
- Validate BST property
- Check if empty
- Clear all nodes
- Print tree structure in visual format
- Print level order traversal

---

*Contributions and improvements are welcome!*

