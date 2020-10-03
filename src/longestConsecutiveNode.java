class longestConsecutiveNode {
    int max = 0;
    public int longestConsecutiveNode(TreeNode root) {
        helper(root);
        return max;
    }
    private int[] helper(TreeNode root){

        if(root == null){
            return new int[] {0,0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] tempMax = {0,0};
        if(root.left != null && root.val - root.left.val == 1){
            tempMax[0] = left[0];
        }
        if(root.left != null && root.val - root.left.val == -1){
            tempMax[1] = left[1];
        }
        if(root.right != null && root.val - root.right.val == 1){
            tempMax[0] = Math.max(right[0],tempMax[0]);
        }
        if(root.right != null && root.val - root.right.val == -1){
            tempMax[1] =Math.max(right[1],tempMax[1]);
        }
        tempMax[0]++; tempMax[1]++;
        max = Math.max(max,Math.max(tempMax[0], tempMax[1]));
        if (root.left != null && root.right != null){
            if (root.left.val + 1 == root.val && root.val + 1 == root.right.val){
                max = Math.max(left[0] + 1 + right[1], max);
            }
            if (root.left.val - 1 == root.val && root.val - 1 == root.right.val){
                max = Math.max(left[1] + 1 + right[0], max);
            }
        }
        return tempMax;
    }
}