# BinarySearchTree

A complete Binary Search Tree implementation in Java with insert, delete, search, and traversal operations.

## What is a BST?

A Binary Search Tree is a binary tree where:
- Left child < Parent < Right child
- Inorder traversal returns sorted elements
- Search, insert, delete are O(log n) on average

## Features

- Insert single or multiple keys
- Search for keys
- Delete keys (handles all cases: leaf, one child, two children)
- Min/max values
- Inorder, preorder, postorder traversals
- Height, leaf count, depth calculations
- Tree visualization

## Usage

```java
BinarySearchTree bst = new BinarySearchTree();

// insert
bst.insert(50);
bst.insert(30);
bst.insertAll(70, 20, 40);

// search
boolean found = bst.search(40);  // true

// delete
bst.delete(30);

// get min/max
int min = bst.min();
int max = bst.max();

// traversals
int[] sorted = bst.inorder();     // [20, 30, 40, 50, 70]
int[] pre = bst.preorder();       // [50, 30, 20, 40, 70]
int[] post = bst.postorder();     // [20, 40, 30, 70, 50]

// tree info
int h = bst.height();
int size = bst.size();
boolean valid = bst.isValid();

// visualize
bst.printTree();
System.out.println(bst);  // BST: [20, 30, 40, 50, 70]
```

Example output:
```
                               60
                                |
                       30--------------70
                        |               |
                   25------40           ---80
                    |       |
                 10--    35--
```

## API Reference

| Method | Description |
|--------|-------------|
| `insert(int)` | Add a key |
| `insertAll(int...)` | Add multiple keys |
| `search(int)` | Check if key exists |
| `delete(int)` | Remove a key |
| `min()` | Get minimum key |
| `max()` | Get maximum key |
| `inorder()` | Sorted array |
| `preorder()` | Preorder array |
| `postorder()` | Postorder array |
| `size()` | Number of nodes |
| `height()` | Tree height |
| `isValid()` | Check BST property |
| `isEmpty()` | Check if empty |
| `clear()` | Remove all nodes |
| `printTree()` | Print tree structure |

## Time Complexity

| Operation | Average | Worst |
|-----------|---------|-------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Traversal | O(n) | O(n) |

