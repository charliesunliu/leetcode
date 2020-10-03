import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CodecSerialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        String str = String.valueOf(root.val) + ",";
        str += serialize(root.left);
        str += serialize(root.right);

        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> strings = new ArrayList<String>(Arrays.asList(data.split(",")));
        return deserializeHelper(strings);
    }
    private TreeNode deserializeHelper(List<String> strings){
        if (strings.get(0).equals("null")){
            strings.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(strings.get(0)));
        strings.remove(0);
        root.left = deserializeHelper(strings);
        root.right = deserializeHelper(strings);

        return root;
    }
}
