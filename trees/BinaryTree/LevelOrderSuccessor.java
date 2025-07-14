import java.util.*;

public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int key = 20; // Node with value 20
        TreeNode ans = Successor(root, key);
        System.out.println(ans.value);
    }
    private static TreeNode Successor(TreeNode root,int key){
        if(root == null ) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null)q.offer(curr.left);
            if(curr.right != null)q.add(curr.right);
            if(curr.value == key) break;
        }
        return q.peek();
    }
}
