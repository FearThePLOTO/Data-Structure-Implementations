# HeapTree

A simple and practical Heap implementation in Java supporting both Min Heap and Max Heap operations.

## What is a Heap?

A Heap is a complete binary tree where:
- **Min Heap**: Parent node is always smaller than or equal to its children
- **Max Heap**: Parent node is always greater than or equal to its children

Heaps are commonly used for priority queues and efficient sorting (heap sort).

## Features

- Min Heap and Max Heap support
- Array-based implementation for O(1) parent/child access
- O(log n) insertion and extraction
- Auto-resizing when capacity is exceeded

## Usage

### Basic Operations

```java
// create a min heap
HeapTree minHeap = HeapTree.minHeap();

// create a max heap
HeapTree maxHeap = HeapTree.maxHeap();

// build heap from array
int[] arr = {45, 30, 60, 15, 50};
HeapTree heap = HeapTree.minHeap(arr);
```

### Insert

```java
HeapTree heap = HeapTree.minHeap();
heap.insert(50);
heap.insert(30);
heap.insert(70);
heap.insertAll(20, 40, 60); // insert multiple
```

### Extract

```java
int root = heap.peek();    // view root without removing
int min = heap.extract();  // remove and return root

// remove specific value
boolean removed = heap.remove(30);
```

### Check and Search

```java
boolean valid = heap.isValid();      // check heap property
boolean has = heap.contains(40);     // search value
int count = heap.count(20);          // count occurrences
int size = heap.size();              // get size
boolean empty = heap.isEmpty();      // check if empty
```

### Convert and Sort

```java
int[] array = heap.toArray();        // to array
int[] sorted = heap.sort();          // to sorted array (ascending)

// extract all for sorting
while (!heap.isEmpty()) {
    System.out.println(heap.extract());
}
```

### Merge

```java
HeapTree h1 = HeapTree.minHeap();
h1.insertAll(10, 20, 30);

HeapTree h2 = HeapTree.minHeap();
h2.insertAll(15, 25, 35);

h1.merge(h2);  // h1 now contains all elements
```

### Visualization

```java
heap.printTree();  // print tree structure
System.out.println(heap);  // compact format like: MinHeap: [10, 20, 30]
```

## API Reference

| Method | Description |
|--------|-------------|
| `insert(int value)` | Add a value |
| `insertAll(int... values)` | Add multiple values |
| `extract()` | Remove and return root |
| `peek()` | View root without removing |
| `remove(int value)` | Remove specific value |
| `contains(int value)` | Check if value exists |
| `count(int value)` | Count occurrences |
| `size()` | Return number of elements |
| `isEmpty()` | Check if empty |
| `isValid()` | Verify heap property |
| `clear()` | Remove all elements |
| `sort()` | Return sorted array |
| `toArray()` | Return array copy |
| `merge(HeapTree other)` | Merge another heap |
| `printTree()` | Print tree structure |


## Time Complexity

| Operation | Time |
|-----------|------|
| Insert | O(log n) |
| Extract | O(log n) |
| Peek | O(1) |
| Search | O(n) |
| Build from array | O(n) |
| Sort | O(n log n) |

