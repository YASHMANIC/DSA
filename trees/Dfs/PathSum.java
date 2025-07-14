public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(hasPathSum(root, targetSum));
        System.out.println(Sum_Root_to_Leaf_Numbers(root, 0));
        System.out.println(maxPathSum(root));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.value == targetSum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, targetSum-root.value) || hasPathSum(root.right, targetSum-root.value) ;
    }

    private static int Sum_Root_to_Leaf_Numbers(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum * 10 + root.value;
        if(root.left == null && root.right == null) return sum;
        return Sum_Root_to_Leaf_Numbers(root.left,sum) + 
        Sum_Root_to_Leaf_Numbers(root.right,sum) ;
    }

    static int ans = Integer.MIN_VALUE;
    private static int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private static int helper(TreeNode root){
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        left = Math.max(0,left);
        right = Math.max(0,right);
        int PathSum = left + right + root.value;
        ans = Math.max(ans,PathSum);
        return Math.max(left,right) + root.value;
    }

}
