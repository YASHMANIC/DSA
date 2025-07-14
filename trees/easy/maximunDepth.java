public class maximunDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(maxDepth(root));
    }
    private static int maxDepth(TreeNode root){
        if(root == null) return 0;
        int len = 0;
        int l =maxDepth(root.right);
        int r =maxDepth(root.left);
        len = Math.max(Math.max(l, r),len);
        return len+1;
    }
}
