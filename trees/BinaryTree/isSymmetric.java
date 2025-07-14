public class isSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        if(root == null) System.out.println("False");
        System.out.println(is_Symmetric(root.left,root.right)); 
    }
    private static boolean is_Symmetric(TreeNode left,TreeNode right){
        if(left == null && right == null) return left == right;
        if(left.value != right.value) return false;
        return (is_Symmetric(left.left, right.right) && 
        is_Symmetric(left.right, right.left));
    }
}
