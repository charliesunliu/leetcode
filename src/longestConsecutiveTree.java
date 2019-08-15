class longestConsecutiveTree {
    public int longestConsecutive(TreeNode root) {
        return helper(root, 1);
    }
    private int helper(TreeNode root, int n){
        if (root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left!=null && root.left.val -1 == root.val){
            left = helper(root.left, n+1);
        }else {
            left = helper(root.left, 1);
        }

        if (root.right!=null && root.right.val -1 == root.val){
            right = helper(root.right, n+1);
        }else {
            right = helper(root.right, 1);
        }


        return Math.max(n, Math.max(left, right));
    }
}
