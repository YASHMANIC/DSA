import java.util.*;

public class binary_tree_right_side_new {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> res = new ArrayList<>();
        right_side_view(res, root);
        for(int i:res){
            System.out.println(i);
        }
    }
    private static List<Integer> right_side_view(List<Integer> res,TreeNode root){
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
            TreeNode curr = q.poll();
             if(curr.left != null)q.offer(curr.left);
             if(curr.right != null)q.offer(curr.right);
             if(i == levelSize-1) res.add(curr.value);   
            }
        }
        return res;
    }
}