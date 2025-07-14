public class populating_right_next_node {
 static class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode next; // Pointer to the next right node
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.next = null; // Initialize next pointer to null
    }
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printTree(node.left);
        printTree(node.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        connect(root);
        printTree(root);   
    }
    private static void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
}
