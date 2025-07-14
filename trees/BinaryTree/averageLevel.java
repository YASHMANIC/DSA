import java.util.*;

public class averageLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Double> result = new ArrayList<>();
        levels(root, result);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
    private static List<Double> levels(TreeNode root,List<Double> res){
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            double average = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                average += curr.value;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.add(average/levelSize);
        }
        return res;
    }
}
