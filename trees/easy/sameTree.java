public class sameTree {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        System.out.println(same(tree1, tree2));
    }
    private static boolean same(TreeNode tree1,TreeNode tree2){
        if(tree1 == null && tree2 == null) return true;
        if(tree1 == null && tree2 != null) return false;
        if(tree1 != null && tree2 == null) return false;
        if(tree1.value != tree2.value) return false;
        return (same(tree1.left, tree2.left) && same(tree1.right, tree2.right));
    }
}
