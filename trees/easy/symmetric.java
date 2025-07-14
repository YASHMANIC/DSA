public class symmetric {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right.left = new TreeNode(4);
        tree1.right.right = new TreeNode(3);
        if(tree1 == null) System.out.println(true);
        System.out.println(isSymmetric(tree1.left, tree1.right));
    }
    private static boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return left == right;
        }
        if(left.value != right.value) return false;
        return (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
    }
}
