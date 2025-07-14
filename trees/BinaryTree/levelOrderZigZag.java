import java.util.*;

public class levelOrderZigZag {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res);
        for (List<Integer> level : res) {
            System.out.println(level);
        }
    }
    private static List<List<Integer>> levelOrder(TreeNode root,List<List<Integer>> res){
        if (root == null) return res;
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                if(!reverse){
                    TreeNode curr = q.pollFirst();
                    ans.add(curr.value);
                    if(curr.left != null) q.addLast(curr.left);
                    if(curr.right != null) q.addLast(curr.right);
            }else{
                    TreeNode curr = q.pollLast();
                    ans.add(curr.value);
                    if(curr.right != null) q.addFirst(curr.right);
                    if(curr.left != null) q.addFirst(curr.left);
                
            }
            }
            reverse = !reverse;
            res.add(ans);
            ans = new ArrayList<>();
        }
        return res;
    }
}
