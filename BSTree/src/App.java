public class App {
    public static void main(String[] args) {
        System.out.println("=== BSTREE  ===\n");

        // insert 
        System.out.println("--- Insert ---");
        BinarySearchTree bst = new BinarySearchTree();
        int[] keys = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35};
        System.out.print("Inserting: ");
        for (int k : keys) {
            System.out.print(k + " ");
            bst.insert(k);
        }
        System.out.println("\n" + bst);
        System.out.println("size: " + bst.size());
        System.out.println("isEmpty: " + bst.isEmpty());

        // search 
        System.out.println("\n--- Search ---");
        System.out.println("search 40: " + bst.search(40));
        System.out.println("search 45: " + bst.search(45));
        System.out.println("min: " + bst.min());
        System.out.println("max: " + bst.max());

        // traversals
        System.out.println("\n--- Traversals ---");
        int[] inorder = bst.inorder();
        System.out.print("inorder (sorted): ");
        for (int k : inorder) System.out.print(k + " ");
        System.out.println();

        int[] preorder = bst.preorder();
        System.out.print("preorder: ");
        for (int k : preorder) System.out.print(k + " ");
        System.out.println();

        int[] postorder = bst.postorder();
        System.out.print("postorder: ");
        for (int k : postorder) System.out.print(k + " ");
        System.out.println();

        // delete 
        System.out.println("\n--- Delete ---");
        System.out.println("before delete: " + bst);
        System.out.println("delete 20: " + bst.delete(20));
        System.out.println("after delete 20: " + bst);
        System.out.println("delete 50 (root): " + bst.delete(50));
        System.out.println("after delete 50: " + bst);
        System.out.println("delete 999 (not found): " + bst.delete(999));
        System.out.println("size: " + bst.size());

        // tree structure
        System.out.println("\n--- Tree Structure ---");
        bst.printTree();
        System.out.println();

        // clear 
        System.out.println("\n--- Clear ---");
        bst.clear();
        System.out.println("after clear: " + bst);
        System.out.println("isEmpty: " + bst.isEmpty());

        System.out.println("\n=== DONE ===");
    }
}

