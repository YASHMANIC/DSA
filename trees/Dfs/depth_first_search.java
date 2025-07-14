import java.util.*;
//preOrder -> root,left,right
//inOrder -> left,root,right
//postOrder ->left,right,root
public class depth_first_search {
    static int maxi = 0;
    static TreeNode head = null;
    static int counter = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        helper(root);
        invertTree(root);
        maxDepth(root);
        revOrder(root);
        Kth_smallest_in_BST(root, 3);
    }
    private static int helper(TreeNode root){
        if(root == null) return 0; 
        int lh = helper(root.left);
        int rh = helper(root.right);
        maxi = Math.max(maxi,lh+rh);
        return 1+Math.max(lh,rh);
    }
    private static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    private static int maxDepth(TreeNode root){
        if( root == null) return 0;
        int len = 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        len = Math.max(len,Math.max(l, r));
        return 1+len;
    }
    private static TreeNode buildBst(int[] nums,int left,int right){
    		if(left > right) {
			System.out.print("null");	
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildBst(nums,left,mid-1);
		root.right = buildBst(nums,mid+1,right);
		System.out.print(root.value);
		return root;
    }
    private static void revOrder(TreeNode root){
        if(root.right != null) revOrder(root.right);
        if(root.left != null) revOrder(root.left);
        root.left = null;
        root.right = head;
        head = root;
//        TreeNode current = root;
//        while(current != null){
//            if(current.left != null){
//                TreeNode temp = current.left;
//                while(temp.right != null)
//                    temp = temp.right;
//                }
//                temp.right = current.right;
//                current.right = current.left;
//                current.left = null;
//            }
//            current = current.right;
//        }
    }
    	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
    private static int Kth_smallest_in_BST(TreeNode root,int k){
    List<Integer> ans = new ArrayList<>();
    Kth_smallest_in_BST_helper(root,ans);
    // return ans.get(k-1);
    return Kth_smallest_in_BST_helper_best(root,k).value;
    }

    private static void Kth_smallest_in_BST_helper(TreeNode root,List<Integer> ans){
    if(root == null) return;
    Kth_smallest_in_BST_helper(root.left,ans);
    ans.add(root.value);
    Kth_smallest_in_BST_helper(root.right,ans);
    }
    
    private static TreeNode Kth_smallest_in_BST_helper_best(TreeNode root,int k){
    if(root == null) return null;
    TreeNode left = Kth_smallest_in_BST_helper_best(root.left,k);
    if(left != null) return left;
    counter++;
    if(counter == k) return root;
    return Kth_smallest_in_BST_helper_best(root.right,k);
    }
    
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int r = preorder[0];
        int index = 0;
        for(int i=0;i<inorder.length;i++){
        if(inorder[i] == r){
        index = i;
        }
        }
        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
    }
    
}








