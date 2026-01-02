public class HeapTree {
    private int[] heap;
    private int size;
    private int capacity;
    private boolean isMinHeap;
    private static final int DEFAULT_CAPACITY = 16;

    // creates empty heap with default capacity
    public HeapTree(boolean isMinHeap) {
        this(DEFAULT_CAPACITY, isMinHeap);
    }

    // creates empty heap with specified capacity
    public HeapTree(int capacity, boolean isMinHeap) {
        this.heap = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.isMinHeap = isMinHeap;
    }

    // builds heap from array
    public HeapTree(int[] array, boolean isMinHeap) {
        this.isMinHeap = isMinHeap;
        this.size = array.length;
        this.capacity = Math.max(array.length * 2, DEFAULT_CAPACITY);
        this.heap = new int[capacity];
        System.arraycopy(array, 0, this.heap, 0, size);
        buildHeap();
    }

    // adds value to heap
    public void insert(int value) {
        if (size == capacity) {
            resize();
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    // adds multiple values at once
    public void insertAll(int... values) {
        for (int v : values) {
            insert(v);
        }
    }

    // removes and returns root element
    public int extract() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (!isEmpty()) {
            heapifyDown(0);
        }
        return root;
    }

    // removes minimum (min heap) or maximum (max heap)
    public int delete() {
        return extract();
    }

    // removes specific value from heap
    public boolean remove(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                heap[i] = heap[size - 1];
                size--;
                if (i < size) {
                    heapifyUp(i);
                    heapifyDown(i);
                }
                return true;
            }
        }
        return false;
    }

    // returns root without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return heap[0];
    }

    // check if heap is valid (satisfies heap property)
    public boolean isValid() {
        if (isEmpty() || size < 2) return true;
        return checkProperty(0);
    }

    // check if heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // returns number of elements
    public int size() {
        return size;
    }

    // check if value exists in heap
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) return true;
        }
        return false;
    }

    // count occurrences of value
    public int count(int value) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) c++;
        }
        return c;
    }

    // clears all elements
    public void clear() {
        size = 0;
    }

    // converts to sorted array
    public int[] sort() {
        int[] sorted = new int[size];
        System.arraycopy(heap, 0, sorted, 0, size);
        heapSort(sorted);
        return sorted;
    }

    // returns array representation
    public int[] toArray() {
        int[] arr = new int[size];
        System.arraycopy(heap, 0, arr, 0, size);
        return arr;
    }

    // string representation
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isMinHeap ? "MinHeap" : "MaxHeap");
        sb.append(": [");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // prints heap in tree format (visual)
    public void printTree() {
        if (isEmpty()) {
            System.out.println("heap is empty");
            return;
        }
        int height = (int) (Math.log(size) / Math.log(2));
        int lines = height + 1;
        int cols = (int) Math.pow(2, lines + 1) * 2;
        char[][] canvas = new char[lines * 2][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        printNodeRec(0, 0, cols / 2, lines, canvas);
        // Trim trailing spaces
        for (int i = 0; i < canvas.length; i++) {
            int lastNonSpace = canvas[i].length - 1;
            while (lastNonSpace >= 0 && canvas[i][lastNonSpace] == ' ') {
                lastNonSpace--;
            }
            if (lastNonSpace >= 0) {
                for (int j = 0; j <= lastNonSpace; j++) {
                    System.out.print(canvas[i][j]);
                }
                System.out.println();
            }
        }
    }

    private void printNodeRec(int index, int level, int pos, int totalLevels, char[][] canvas) {
        if (index >= size) return;
        String str = String.valueOf(heap[index]);
        int start = pos - str.length() / 2;
        for (int i = 0; i < str.length(); i++) {
            canvas[level * 2][start + i] = str.charAt(i);
        }
        if (level < totalLevels - 1) {
            int leftPos = pos - (int) Math.pow(2, totalLevels - level - 1);
            int rightPos = pos + (int) Math.pow(2, totalLevels - level - 1);
            int line = level * 2 + 1;
            int branchLine = level * 2 + 2;
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left < size) {
                canvas[line][pos] = '|';
                canvas[branchLine][leftPos] = '/';
                for (int i = leftPos + 1; i <= pos; i++) {
                    canvas[branchLine][i] = '-';
                }
            }
            if (right < size) {
                canvas[line][pos] = '|';
                canvas[branchLine][rightPos] = '\\';
                for (int i = pos; i < rightPos; i++) {
                    canvas[branchLine][i] = '-';
                }
            }
            if (left < size && right >= size) {
                canvas[line][pos] = '|';
            }
            if (right < size && left >= size) {
                canvas[line][pos] = '|';
            }
            printNodeRec(left, level + 1, leftPos, totalLevels, canvas);
            printNodeRec(right, level + 1, rightPos, totalLevels, canvas);
        }
    }

    // merges another heap into this one
    public void merge(HeapTree other) {
        if (other.isEmpty()) return;
        if (this.isMinHeap != other.isMinHeap) {
            throw new RuntimeException("cannot merge min and max heap");
        }
        for (int v : other.toArray()) {
            insert(v);
        }
    }

    // static factory for min heap
    public static HeapTree minHeap() {
        return new HeapTree(true);
    }

    // static factory for min heap from array
    public static HeapTree minHeap(int[] arr) {
        return new HeapTree(arr, true);
    }

    // static factory for max heap
    public static HeapTree maxHeap() {
        return new HeapTree(false);
    }

    // static factory for max heap from array
    public static HeapTree maxHeap(int[] arr) {
        return new HeapTree(arr, false);
    }

    // === internal methods ===

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (shouldSwap(index, parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int target = index;

            if (left < size && shouldSwap(left, target)) target = left;
            if (right < size && shouldSwap(right, target)) target = right;

            if (target != index) {
                swap(index, target);
                index = target;
            } else {
                break;
            }
        }
    }

    private boolean shouldSwap(int child, int parent) {
        return isMinHeap ? heap[child] < heap[parent] : heap[child] > heap[parent];
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private boolean checkProperty(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size) {
            if (isMinHeap ? heap[index] > heap[left] : heap[index] < heap[left]) {
                return false;
            }
            if (!checkProperty(left)) return false;
        }

        if (right < size) {
            if (isMinHeap ? heap[index] > heap[right] : heap[index] < heap[right]) {
                return false;
            }
            if (!checkProperty(right)) return false;
        }

        return true;
    }

    private void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            sortHeapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sortHeapify(arr, i, 0);
        }
    }

    private void sortHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            sortHeapify(arr, n, largest);
        }
    }

    private void resize() {
        int newCap = capacity * 2;
        int[] newHeap = new int[newCap];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
        capacity = newCap;
    }
}

