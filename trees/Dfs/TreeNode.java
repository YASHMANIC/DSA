public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
