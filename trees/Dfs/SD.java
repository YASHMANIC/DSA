import java.util.*;

public class SD {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String data = serialize(root);
        TreeNode node = deserialize(data);
        TreeNode.printTree(node);
    }
    public static String serialize(TreeNode root) {
        StringBuilder ser = new StringBuilder();
        return helper(root, ser);
    }

    static String helper(TreeNode root,StringBuilder ser){
        if(root == null) {
            ser.append("null,");
            return ser.toString();
        }  
        ser.append(String.valueOf(root.value)+",");
        helper(root.left, ser);
        helper(root.right, ser);
        return ser.toString();
    }

    // // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String [] res = data.split(",");
        List<String> resList = new ArrayList<>(Arrays.asList(res));
        Collections.reverse(resList);
        return helper2(resList);
    }
    static TreeNode helper2(List<String> resList){
        String val = resList.remove(resList.size()-1);
        if(val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(resList);
        node.right = helper2(resList);
        return node;
    }
}
