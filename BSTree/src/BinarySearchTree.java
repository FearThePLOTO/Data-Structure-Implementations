public class BinarySearchTree {
    private Node root;
    private int size;

    // node class
    private class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    // empty tree
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // insert a key
    public void insert(int key) {
        root = insertRec(root, key);
        size++;
    }

    private Node insertRec(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    // insert multiple keys
    public void insertAll(int... keys) {
        for (int k : keys) {
            insert(k);
        }
    }

    // search for a key
    public boolean search(int key) {
        return searchRec(root, key) != null;
    }

    private Node searchRec(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }
        if (key < node.key) {
            return searchRec(node.left, key);
        }
        return searchRec(node.right, key);
    }

    // delete a key
    public boolean delete(int key) {
        if (!search(key)) return false;
        root = deleteRec(root, key);
        size--;
        return true;
    }

    private Node deleteRec(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key);
        }
        return node;
    }

    private int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    // get minimum key
    public int min() {
        if (root == null) throw new RuntimeException("tree is empty");
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    // get maximum key
    public int max() {
        if (root == null) throw new RuntimeException("tree is empty");
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.key;
    }

    // inorder traversal - returns sorted array
    public int[] inorder() {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        inorderRec(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorderRec(Node node, java.util.List<Integer> list) {
        if (node == null) return;
        inorderRec(node.left, list);
        list.add(node.key);
        inorderRec(node.right, list);
    }

    // preorder traversal
    public int[] preorder() {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        preorderRec(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preorderRec(Node node, java.util.List<Integer> list) {
        if (node == null) return;
        list.add(node.key);
        preorderRec(node.left, list);
        preorderRec(node.right, list);
    }

    // postorder traversal
    public int[] postorder() {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        postorderRec(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void postorderRec(Node node, java.util.List<Integer> list) {
        if (node == null) return;
        postorderRec(node.left, list);
        postorderRec(node.right, list);
        list.add(node.key);
    }

    // get size
    public int size() {
        return size;
    }

    // check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // clear the tree
    public void clear() {
        root = null;
        size = 0;
    }

    // get height
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    // check if BST is valid
    public boolean isValid() {
        return isValidRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidRec(Node node, int min, int max) {
        if (node == null) return true;
        if (node.key <= min || node.key >= max) return false;
        return isValidRec(node.left, min, node.key - 1) &&
               isValidRec(node.right, node.key + 1, max);
    }



    // string representation
    @Override
    public String toString() {
        int[] arr = inorder();
        StringBuilder sb = new StringBuilder();
        sb.append("BST: [");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // print tree as a visual tree
    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        int treeHeight = height();
        int lines = treeHeight + 1;
        int cols = (int) Math.pow(2, lines + 1) * 2;
        char[][] canvas = new char[lines * 2][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        printTreeRec(root, 0, cols / 2, 0, lines, canvas);
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

    private void printTreeRec(Node node, int level, int pos, int row, int totalLevels, char[][] canvas) {
        if (node == null) return;
        String str = String.valueOf(node.key);
        int start = pos - str.length() / 2;
        for (int i = 0; i < str.length(); i++) {
            canvas[level * 2][start + i] = str.charAt(i);
        }
        if (level < totalLevels - 1) {
            int leftPos = pos - (int) Math.pow(2, totalLevels - level - 1);
            int rightPos = pos + (int) Math.pow(2, totalLevels - level - 1);
            int line = level * 2 + 1;
            int branchLine = level * 2 + 2;
            if (node.left != null) {
                canvas[line][pos] = '|';
                canvas[branchLine][leftPos] = '/';
                for (int i = leftPos + 1; i <= pos; i++) {
                    canvas[branchLine][i] = '-';
                }
            }
            if (node.right != null) {
                canvas[line][pos] = '|';
                canvas[branchLine][rightPos] = '\\';
                for (int i = pos; i < rightPos; i++) {
                    canvas[branchLine][i] = '-';
                }
            }
            if (node.left == null && node.right != null) {
                canvas[line][pos] = '|';
            }
            if (node.right == null && node.left != null) {
                canvas[line][pos] = '|';
            }
            printTreeRec(node.left, level + 1, leftPos, row, totalLevels, canvas);
            printTreeRec(node.right, level + 1, rightPos, row, totalLevels, canvas);
        }
    }
}