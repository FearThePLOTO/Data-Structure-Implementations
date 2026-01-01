# Java Stack Implementation

This repository contains a simple implementation of a **Stack** data structure in Java using an array-based approach. The `Stack` class is built completely from scratch without using Java's built-in `Stack`, making it perfect for understanding how stacks work internally.

---

## Package

```
Stack.src
```

---

## Features

- **Push** - Add elements to the top of the stack
- **Pop** - Remove and return the top element
- **Peek** - View the top element without removing it
- **Check if empty** - Determine if the stack is empty
- **Check if full** - Determine if the stack has reached capacity
- **Get size** - Get the current number of elements in the stack
- **Generic implementation** - Works with any data type

---

## Usage

```java
public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Top element after pop is: " + stack.peek());
        System.out.println("Stack size after pop is: " + stack.size());
    }
}
```

---

## API Reference

| Method | Description | Time Complexity |
|--------|-------------|-----------------|
| push(item element) | Adds an element to the top of the stack | O(1) |
| pop() | Removes and returns the top element | O(1) |
| peek() | Returns the top element without removing it | O(1) |
| isEmpty() | Returns true if the stack is empty | O(1) |
| isFull() | Returns true if the stack is full | O(1) |
| size() | Returns the number of items in the stack | O(1) |

---

## Exception Handling

- `push()` throws a `RuntimeException` with message "Stack Overflow" if the stack is full
- `pop()` throws a `RuntimeException` with message "Stack Underflow" if called on an empty stack
- `peek()` throws a `RuntimeException` with message "Stack is empty" if called on an empty stack

---

## Stack Properties

- **LIFO (Last In, First Out)**: The last element added is the first one to be removed
- **Array Based**: Uses an internal array with fixed capacity for storage
- **Generic**: Can store any data type using Java generics

---

## Requirements

- Java Development Kit (JDK) 8 or higher

