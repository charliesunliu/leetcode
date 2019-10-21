import java.sql.Array;
import java.util.*;


public class Main {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static   public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public static void main(String[] args) {


        threeSum test = new threeSum();


        int[] n = {-1, 0, 1, 2, -1, -4};

        test.threeSum(n);

    }

    static class findMissingRanges {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            long lower_ = lower;
            long upper_ = upper;
            List<String> result = new ArrayList<>();
            if(nums.length == 0){
                if (lower_ < upper_){
                    result.add(lower_ + "->" + upper_);
                }else if (lower_ == upper_){
                    result.add(lower_+"");
                }
                return result;
            }
            if (nums[0] != lower){
                lower_ = lower_ - 1;
            }
            if (nums[nums.length - 1] != upper){
                upper_ = upper_ + 1;
            }

            for (int i = 0; i <= nums.length; i++){
                long left;
                long right;
                if (i == 0){
                    left = lower_ + 1;
                    right = Long.valueOf(nums[i]) - 1;
                }else if (i == nums.length){
                    left = Long.valueOf(nums[i-1]) + 1;
                    right = upper_ - 1;
                }else{
                    left = Long.valueOf(nums[i-1]) + 1;
                    right = Long.valueOf(nums[i]) - 1;
                }
                if (left < right){
                    result.add(left + "->" + right);
                }else if (left == right){
                    result.add(left+"");
                }
            }
            return result;
        }
    }

    static class distanceK {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }

            HashMap<TreeNode, TreeNode> map = new HashMap<>();
            distanceKMapBuilder(root, map);
            distanceKHelper(target, map, null, K, result);

            return result;
        }
        private void distanceKMapBuilder(TreeNode root, HashMap<TreeNode, TreeNode> map){
            if (root.left != null){
                map.put(root.left, root);
                distanceKMapBuilder(root.left, map);
            }
            if (root.right != null){
                map.put(root.right, root);
                distanceKMapBuilder(root.right, map);
            }
        }
        private void distanceKHelper(TreeNode root, HashMap<TreeNode, TreeNode> map, TreeNode pre, int K, List<Integer> result){
            if (root != null && K == 0){
                result.add(root.val);
            }
            if (root.left != null && root.left != pre){
                distanceKHelper(root.left, map, root, K - 1, result);
            }
            if (root.right != null && root.right != pre){
                distanceKHelper(root.right, map, root, K - 1, result);
            }
            if (map.get(root) != null && pre != map.get(root)){
                distanceKHelper(map.get(root), map, root, K - 1, result);
            }
        }
    }

    static class shortestDistance {

        public int shortestDistance(String[] words, String word1, String word2) {

            int count = Integer.MAX_VALUE;
            int indexOne = -1;
            int indexTwo = -1;
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    if (indexTwo == -1){
                        indexOne = i;
                    }else{
                        indexOne = i;
                        count = Math.min(count, Math.abs(indexOne - indexTwo));
                    }
                }
                 if (words[i].equals(word2)){
                     if (indexOne == -1){
                         indexTwo = i;
                     }else{
                         indexTwo = i;
                         count = Math.min(count, Math.abs(indexOne - indexTwo));
                     }
                 }
            }
            return count;
        }
    }

    static class maxIncreaseKeepingSkyline {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            if (grid.length == 0){
                return 0;
            }
            int[] topBotMax = new int[grid[0].length];
            int[] leftRightMax = new int[grid.length];
            for(int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length; j++){
                    topBotMax[j] = Math.max(topBotMax[j], grid[i][j]);
                    leftRightMax[i] = Math.max(leftRightMax[i], grid[i][j]);
                }
            }
            int increase = 0;
            for(int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length; j++){
                    increase += (Math.min(leftRightMax[i], topBotMax[j]) - grid[i][j]);
                }
            }
            return increase;
        }
    }
    static class numJewelsInStones {
        public int numJewelsInStones(String J, String S) {
            if (J.length() == 0 || S.length() == 0){
                return 0;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < J.length(); i++){
                if (!set.contains(J.charAt(i))){
                    set.add(J.charAt(i));
                }
            }
            int count = 0;
            for(int i = 0; i < S.length(); i++){
                if (set.contains(S.charAt(i))){
                    count++;
                }
            }
            return count;
        }
    }
    static class regionsBySlashes {
        public int regionsBySlashes(String[] grid) {
            int[][] newGrid = new int[grid.length * 3][grid.length * 3];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length(); j++) {
                    if (grid[i].charAt(j) == '/') {
                        int i_ = i * 3;
                        int j_ = j * 3;
                        newGrid[i_][j_ + 2] = 1;
                        newGrid[i_ + 1][j_ + 1] = 1;
                        newGrid[i_ + 2][j_] = 1;

                    } else if (grid[i].charAt(j) == '\\') {
                        int i_ = i * 3;
                        int j_ = j * 3;
                        newGrid[i_][j_] = 1;
                        newGrid[i_ + 1][j_ + 1] = 1;
                        newGrid[i_ + 2][j_ + 2] = 1;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < newGrid.length; i++) {
                for (int j = 0; j < newGrid[0].length; j++) {
                    if (newGrid[i][j] == 0) {
                        regionsBySlashesHelper(newGrid, i, j);
                        cnt++;
                    }
                }
            }
            return cnt;
        }
        private void regionsBySlashesHelper(int[][] g, int i, int j){
            int n = g.length, m = g[0].length;
            if(i<0 || i>=n || j<0 || j>=m || g[i][j]==1) return;
            g[i][j]=1;
            int d[] = {0,-1,0,1,0};
            for(int k=0;k<4;k++){
                regionsBySlashesHelper(g,i+d[k],j+d[k+1]);
            }
        }
    }



    static class buildTree {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0){
                return null;
            }
            return buildTreeHelper(preorder, 0, inorder, 0, inorder.length-1);
        }
        private TreeNode buildTreeHelper(int[] preorder, int preStart, int[] inorder, int inStart,int inEnd){
            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int rootIndex = inStart;
            while (preorder[preStart] != inorder[rootIndex]){
                rootIndex++;
            }
            root.left = buildTreeHelper(preorder, preStart + 1, inorder, inStart, rootIndex - 1);
            root.right = buildTreeHelper(preorder, preStart + rootIndex - inStart + 1, inorder, rootIndex + 1, inEnd);


            return root;
        }
    }
    static class merge {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1;
            int j = n-1;
            int k = m+n-1;
            while (i >= 0 && j >= 0){
                if (nums1[i] >= nums2[j]){
                    nums1[k] = nums1[i];
                    i--;
                    k--;
                }else {
                    nums1[k] = nums2[j];
                    j--;
                    k--;
                }
            }

            while (i >= 0){
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            while (j >= 0){
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    static class numDecodings {
        public int numDecodings(String s) {
            if (s.length() == 0 || s.charAt(0) == '0'){
                return 0;
            }
            int[] ans = new int[s.length()+1];
            ans[0] = 1;
            ans[1] = s.charAt(1) != '0' ? 1 : 0;
            int i = 2;
            for (i = 2;i < ans.length;i++){
                if (i < s.length() && s.charAt(i) == '0'){
                    continue;
                }
                if (Integer.parseInt(s.substring(i-2,i))<= 26){
                    ans[i] = ans[i-2] + ans[i-1];
                }else {
                    ans[i] = ans[i-1];
                }
            }
            return ans[ans.length-1];
        }
    }

    static class pushDominoes {
        public String pushDominoes(String dominoes) {
            StringBuilder domiBuilder = new StringBuilder(dominoes);
            int i = 0;
            int j = 0;
            for (j = 0; j < domiBuilder.length(); j++){
                if (domiBuilder.charAt(j) == 'R'){
                    if (domiBuilder.charAt(i) == 'R'){
                        while (i < j){
                            domiBuilder.replace(i, i+1, "R");
                            i++;
                        }
                    }else{
                        i = j;
                    }
                }else if (domiBuilder.charAt(j) == 'L'){
                    if (domiBuilder.charAt(i) == 'R'){
                        int i_ = i;
                        int j_ = j;
                        while (i_ < j_){
                            domiBuilder.replace(i_, i_+1,"R");
                            domiBuilder.replace(j_, j_+1,"L");
                            i_++; j_--;
                        }
                        if (i_ == j_){
                            domiBuilder.replace(i_, i_+1, ".");
                        }
                        i = j;
                    }else{
                        while (i < j){
                            domiBuilder.replace(i, i+1, "L");
                            i++;
                        }
                    }
                }
            }
            if (domiBuilder.charAt(j-1) == '.' && domiBuilder.charAt(i) == 'R'){
                while (i < j){
                    domiBuilder.replace(i, i+1, "R");
                    i++;
                }
            }
            return domiBuilder.toString();
        }
    }

    static class groupAnagrams {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList> map = new HashMap<>();
            for(String s : strs){
                String temp = groupAnagramsHashHelper(s);
                if (map.containsKey(temp)){
                    map.get(temp).add(s);
                }else {
                    ArrayList<String> tempList = new ArrayList<>();
                    tempList.add(s);
                    map.put(temp, tempList);
                }
            }
            List<List<String>> result = new ArrayList<>();
            for (ArrayList v : map.values()){
                result.add(v);
            }
            return result;
        }
        private String groupAnagramsHashHelper(String s){
            int cap = 26;
            StringBuilder charCounter = new StringBuilder(cap);
            for (int i = 0; i < cap; i++){
                charCounter.append("0");
            }
            for (int i = 0; i < s.length(); i++){
                int temp =  (int) s.charAt(i);
                temp -= 97;
                int t = (Character.getNumericValue(charCounter.charAt(temp)) + 1);
                char tt = Character.forDigit(t, 10);
                charCounter.setCharAt(temp, tt);
            }


            return charCounter.toString();
        }
    }
    static class searchMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int rowNum = matrix.length / 2;
            int minRow = 0;
            int maxRow = matrix.length - 1;
            while (minRow <= maxRow){
                if (target < matrix[rowNum][0]){
                    maxRow = rowNum - 1;
                    rowNum = minRow + (maxRow - minRow)/2;
                } else if (target > matrix[rowNum][0]){
                    minRow = rowNum + 1;
                    rowNum = minRow + (maxRow - minRow)/2;
                } else if (target == matrix[rowNum][0]){
                    return true;
                }
            }

            if (minRow == 0){
                return false;
            }
            int min = 0;
            int max = matrix[0].length - 1;
            int row = minRow - 1;
            while (min <= max && min >= 0 && max < matrix[0].length) {
                int mid = min + (max - min) / 2;
                if (matrix[row][mid] == target) return true;
                else if (target < matrix[row][mid]) max = mid - 1;
                else min = mid + 1;
            }

            return false;
        }
    }

    static class setZeroes {
        public void setZeroes(int[][] matrix) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[i].length; j++){
                    if (matrix[i][j] == 0){
                        rowSet.add(i);
                        colSet.add(j);
                    }
                }
            }
            for (Integer rownum : rowSet){
                for (int j = 0; j < matrix[rownum].length; j++){
                    matrix[rownum][j] = 0;
                }
            }
            for (Integer colnum : colSet){
                for (int i = 0; i < matrix.length; i++){
                    matrix[i][colnum] = 0;
                }
            }
        }
    }

    static class inorderTraversal {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }
        private void helper(TreeNode root, List<Integer> result){
            if (root == null){
                return;
            }

            helper(root.left, result);
            result.add(root.val);
            helper(root.right,result);

        }
    }
    static class minWindow {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++){
                if (tmap.containsKey(t.charAt(i))){
                    tmap.put(t.charAt(i), tmap.get(t.charAt(i))-1);
                }else{
                    tmap.put(t.charAt(i), -1);
                }

            }
            int tLength = t.length();

            int L = 0;
            int R = 0;
            String result = "";

            while (R < s.length()){

                if (tmap.containsKey(s.charAt(R))){
                    tmap.put(s.charAt(R), tmap.get(s.charAt(R)) + 1);
                    if (tmap.get(s.charAt(R)) <= 0){
                        tLength--;
                    }
                }
                while (tLength == 0){
                    if (result == "" ||(R - L) < result.length()){
                        result = s.substring(L, R+1);
                    }
                    if (tmap.containsKey(s.charAt(L))){
                        tmap.put(s.charAt(L), tmap.get(s.charAt(L)) - 1);
                        if (tmap.get(s.charAt(L)) < 0) {
                            tLength++;
                        }
                    }
                    L++;
                }
                R++;
            }
            return result;
        }
    }

    static class videoStitching {

        public int videoStitching(int[][] clips, int T) {

            Arrays.sort(clips, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return a[0] - b[0];
                    }
                    return - Integer.compare(a[1], b[1]);
                }
            });
            if (clips[0][0] > 0){
                return -1;
            }
            int end = clips[0][1];
            int result = 1;
            int i = 1;
            int maxend = end;
            if (end >= T){
                return result;
            }
            while (i < clips.length){
                while ( i < clips.length && clips[i][0] <= end){
                    maxend = Math.max(clips[i][1], maxend);
                    i++;
                }
                if (maxend == end){
                    i++;
                }else {
                    end = maxend;
                    result++;
                }
                if (end >= T){
                    return result;
                }
            }
            return -1;
        }
    }

    static class generateParenthesis {
        public List<String> generateParenthesis(int n) {
            List<String> result = new LinkedList<>();
            gpHelper(result, "", n, n);

            return result;
        }
        private void gpHelper(List<String> result, String temp, int left, int right){
            if (left == 0 && right == 0){
                result.add(temp);
            }
            if (left > 0){
                gpHelper(result, temp+"(", left - 1, right);
            }
            if (left < right){
                gpHelper(result, temp + ")", left, right - 1);
            }
        }
    }

    static class isValid {
        public boolean isValid(String s) {
            Stack<Character> list = new Stack<>();
            for (int i = 0; i <s.length(); i++){
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{'){
                    list.push(c);
                }else {
                    if(list.empty()){
                        return false;
                    }
                    char p = list.pop();
                    if (!((p == '(' && c == ')') || (p == '{' && c == '}') || (p == '[' && c == ']'))){
                        return false;
                    }
                }
            }
            if(!list.empty()){
                return false;
            }
            return true;
        }
    }

    static class simplifyPath {
        public String simplifyPath(String path) {
            String [] arrofFiles = path.split("/");

            Stack<String> l = new Stack<String>();
            for (int i = 0; i < arrofFiles.length; i++) {
                if (arrofFiles[i].equals("") || arrofFiles[i].equals(".") ){
                }else if (arrofFiles[i].equals("..") && !l.empty()){
                    l.pop();
                }else {
                    l.push(arrofFiles[i]);
                }
            }
            String result = "";
            while (!l.empty()){
                result = "/" + l.pop() + result;

            }
            if (result == ""){
                return "/";
            }
            return result;
        }
    }

    static class reverseBetween {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null || m == n){
                return head;
            }
            int i = 1;
            ListNode start = null;
            ListNode pre = head;
            ListNode pointer = head.next;
            while (i < m){
                i++;
                start = pre;
                pre = pre.next;
                pointer = pointer.next;
            }
            ListNode k = pre;

            while(pointer != null && i < n){
                i++;
                ListNode temp = pointer;
                pointer = temp.next;
                temp.next = pre;
                pre = temp;
            }
            k.next = pointer;
            if (start == null){
                //head.next = null;
                return pre;
            }else {
                start.next = pre;
                return head;
            }
        }
    }

    static class reverseList {
        public ListNode reverseList(ListNode head) {
            ListNode pre = head;
            ListNode pointer = head.next;
            while(pointer != null){
                ListNode temp = pointer;
                pointer = temp.next;
                temp.next = pre;
                pre = temp;
            }
            head.next = null;
            return pre;
        }
    }
    static class sortColors {
        public void sortColors(int[] nums) {
            int zeroP = 0;
            int twoP = nums.length - 1;
            int pointer = 0;
            while (pointer <= twoP){
                if (nums[pointer] == 0){
                    int temp = nums[zeroP];
                    nums[pointer] = temp;
                    nums[zeroP] = 0;
                    zeroP++;
                }
                else if (nums[pointer] == 2){
                    int temp = nums[twoP];
                    nums[pointer] = temp;
                    nums[twoP] = 2;
                    twoP--;
                }
                if (pointer < zeroP || nums[pointer] == 1){
                    pointer++;
                }
            }
        }
    }
    static class uniquePathsWithObstacles {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] map = new int[m][n];
            map[0][0] = 1;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (i - 1  >= 0){
                        map[i][j] += map[i-1][j];
                    }
                    if (j - 1 >= 0 && obstacleGrid[i][j-1] != 1){
                        map[i][j] += map[i][j-1];
                    }
                    if (obstacleGrid[i][j] == 1){
                        map[i][j] = 0;
                    }
                }
            }
            return map[m-1][n-1];
        }
    }

    static class uniquePaths {
        public int uniquePaths(int m, int n) {
            int[][] map = new int[m][n];
            map[0][0] = 1;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (i - 1  >= 0){
                        map[i][j] += map[i-1][j];
                    }
                    if (j - 1 >= 0){
                        map[i][j] += map[i][j-1];
                    }
                }
            }


            return map[m-1][n-1];
        }
    }

    static class letterCombinations {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            String[] keyboard = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

            letterCombinationsHelper(result, keyboard, digits, 0, "");

            return result;
        }
        private void letterCombinationsHelper(List<String> result, String[] keyboard, String digits, int pointer, String temp){
            if (pointer == digits.length()){
                result.add(new String(temp)); //String no need new
                return;
            }
            int num = Character.getNumericValue(digits.charAt(pointer));
            String key = keyboard[num];
            if (key == ""){
                letterCombinationsHelper(result, keyboard, digits, pointer+1, temp);
            }else {
                for (int i = 0; i < key.length(); i++){
                    letterCombinationsHelper(result, keyboard, digits, pointer+1, temp + key.charAt(i));
                    //temp = temp.substring(0, temp.length() - 1);
                }
            }
        }
    }

    static class bstFromPreorder {

        public TreeNode bstFromPreorder(int[] preorder) {

            TreeNode root = new TreeNode(preorder[0]);
            if (preorder.length == 1){
                return root;
            }
            Stack<TreeNode> helper = new Stack<>();
            TreeNode pointer = root;
            helper.push(root);
            for(int i = 1; i < preorder.length; i++){
                TreeNode temp = new TreeNode(preorder[i]);
                if (preorder[i] < pointer.val){
                    pointer.left = temp;
                    pointer = pointer.left;
                    helper.push(temp);
                }else {

                    while (!helper.empty() && helper.peek().val < preorder[i]){
                        pointer = helper.pop();
                    }
                    pointer.right = temp;
                    pointer = pointer.right;
                    helper.push(temp);
                }
            }
            return root;
        }
    }

    static class shipWithinDays {
        public int shipWithinDays(int[] weights, int D) {

            int sum = 0;

            for (int weight : weights){
                sum += weight;
            }


            int min = 0;    //Should be the min
            int max = sum;  //Shoold be Max(ave, largest);

            int cap = (max - min) / 2;
            while (min < max){


                int weightPointer = 0;
                int day = 0;
                while (day < D && weightPointer < weights.length){
                    int currentWeights = 0;
                    while (currentWeights <= cap && weightPointer < weights.length){
                        currentWeights += weights[weightPointer];
                        weightPointer++;
                    }
                    if (currentWeights > cap){
                        weightPointer--;
                        currentWeights -= weights[weightPointer];
                    }
                    day++;
                }
                if (day == D && weightPointer < weights.length){
                    min = cap+1;
                    cap = min + (max - (cap+1))/2;
                }else{
                    max = cap - 1;
                    cap = min + ((cap-1) - min)/2;
                }
            }

            return cap;
        }
    }

    static class solveNQueens {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char[] dots = new char[n];
            Arrays.fill(dots, '.');
            String line = new String(dots);
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++){
                temp.add(i, line);
            }
            queenHelper(result, temp, 0, 0, n);

            return result;
        }
        private void queenHelper(List<List<String>> result, List<String> temp, int i, int j, int n){
            if (i >= n){
                i = 0;
                j++;
            }
            if (j >= n){
                result.add(new ArrayList<>(temp));
                System.out.println(temp);
                System.out.println("---------------------------");
                return;
            }
            StringBuilder tempSb = new StringBuilder(temp.get(j));
            tempSb.setCharAt(i, 'Q');
            temp.set(j, tempSb.toString());
            if (validQueen(temp, n)){
                queenHelper(result, temp, i+1, j, n);
            }
            tempSb.setCharAt(i, '.');
            temp.set(j, tempSb.toString());
        }
        private boolean validQueen(List<String> temp, int n){

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (temp.get(j).charAt(i) == 'Q'){
                        //check row
                        for (int i_ = 0; i_ < n; i_++){
                            if (i_ != i && temp.get(j).charAt(i_) == 'Q'){
                                return false;
                            }
                        }
                        //check row
                        //check col
                        for (int j_ = 0; j_ < n; j_++){
                            if (j_ != j && temp.get(j_).charAt(i) == 'Q'){
                                return false;
                            }
                        }
                        //check col
                        //check \
                        int l = 1;
                        while ((i - l >=0 && j - l >=0) || (i + l < n && j - l >=0) || (i - l >=0 && j + l < n) || (i + l <n && j + l < n)){

                            if (i - l >=0 && j - l >=0){
                                if (temp.get(j - l).charAt(i - l) == 'Q'){
                                    return false;
                                }
                            }
                            if (i + l < n && j - l >=0){
                                if (temp.get(j - l).charAt(i + l) == 'Q'){
                                    return false;
                                }
                            }
                            if (i - l >=0 && j + l < n){
                                if (temp.get(j + l).charAt(i - l) == 'Q'){
                                    return false;
                                }
                            }
                            if (i + l <n && j + l < n){
                                if (temp.get(j + l).charAt(i + l) == 'Q'){
                                    return false;
                                }
                            }

                            l++;
                        }
                    }

                }
            }

            return true;
        }
    }


    class subsetsWithDup {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            List<Integer> temp = new ArrayList<>();
            subsetWithDupHelper(result, nums, 0, temp);

            return result;
        }
        private void subsetWithDupHelper(List result, int[] nums, int pointer, List temp){
            if (!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            if (pointer == nums.length){
                return;
            }
            while (pointer < nums.length){
                if (pointer + 1 < nums.length && nums[pointer] == nums[pointer+1]){
                    pointer++;
                    continue;
                }

                temp.add(nums[pointer]);
                pointer++;
                subsetWithDupHelper(result, nums, pointer, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    static class grayCode {
        public void grayCode(int n){
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++){
                s.append("0");
            }
            greyCodeHelper(s, 0, n);
        }
        private void greyCodeHelper(StringBuilder s, int pointer, int n){
            if (pointer == n){
                System.out.println(s.toString());
                return;
            }


            greyCodeHelper(s, pointer+1, n);
            if (s.toString().charAt(pointer) == '0'){
                s.replace(pointer, pointer+1, "1");
            }else{
                s.replace(pointer, pointer+1, "0");
            }
            greyCodeHelper(s, pointer+1, n);

        }
    }
    static class combinationSum {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList();
            combinationSumHelper(candidates, target, new ArrayList<Integer>(), result, 0);

            return result;
        }
        private void combinationSumHelper (int[] candidates,int target, List<Integer> temp, List<List<Integer>> result, int i){
            if (target == 0){
                result.add(new ArrayList(temp));
            }
            while (i < candidates.length && candidates[i] <= target){
                temp.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], temp, result , i);
                temp.remove(temp.size() - 1);
                i++;
            }
            return;
        }
    }

    static class trap {
        public int trap(int[] height) {
            int leftpointer = 0;
            int rightpointer = height.length-1;
            int leftMax = height[leftpointer];
            int rightMax = height[rightpointer];
            int water = 0;
            while(leftpointer != rightpointer){
                if(leftMax > height[leftpointer]) water += leftMax - height[leftpointer];
                if(rightMax > height[rightpointer]) water += rightMax - height[rightpointer];
                leftMax = Math.max(leftMax, height[leftpointer]);
                rightMax = Math.max(rightMax, height[rightpointer]);
                if(height[leftpointer] <= height[rightpointer]) leftpointer++;
                else rightpointer--;
            }
            return water;
        }
    }

    static class firstMissingPositive {
        public int firstMissingPositive(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0 && nums[i]<= nums.length && nums[i] != nums[nums[i] - 1]){
                    swap(nums, i, nums[i] - 1);
                }
            }
            int i = 0;
            while(i < nums.length && nums[i] == i+1){
                i += 1;
            }
            return i+1;
        }
        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    static class subsets {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            subsetsHelper(result, temp, nums, 0);
            return result;
        }
        private void subsetsHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, int i){
            result.add(new ArrayList<Integer>(temp));
            if (i >= nums.length){
                return;
            }
            while (i < nums.length){
                temp.add(nums[i]);
                subsetsHelper(result, temp, nums, ++i);
                if (temp.size() != 0) {
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    static class permute {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            permuteHelper(result, temp, nums);

            return result;
        }
        private void permuteHelper( List<List<Integer>> result, List<Integer> temp, int[] nums){
            if (temp.size() == nums.length){
                result.add(new ArrayList<>(temp));
            }else {
                for (int i = 0; i < nums.length; i++){
                    if (temp.contains(nums[i])) continue;
                    temp.add(nums[i]);
                    permuteHelper(result, temp, nums);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    static private class isValidBST {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(pre != null && root.val <= pre.val) return false;
                pre = root;
                root = root.right;
            }
            return true;
        }
    }

}
