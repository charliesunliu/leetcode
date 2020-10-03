import java.util.HashMap;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

//PriorityQueue<Node> pq = new PriorityQueue<Node>(initCapacity, new Comparator<Node>() {
//public int compare(Node n1, Node n2) {
//        // compare n1 and n2
//        }
//        });

class Calculate{
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int currentNum = 0;
        char sign = '+';
        while(i < s.length()){
            if(s.charAt(i) - '0' < 10 && s.charAt(i) - '0' >= 0){
                currentNum = currentNum * 10 + (s.charAt(i) - '0');
            }
            if((s.charAt(i) - '0' > 10 || s.charAt(i) - '0' < 0) && s.charAt(i) != ' ' || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(currentNum);

                }
                else if(sign == '-'){
                    stack.push(-currentNum);
                }
                else if(sign == '*'){
                    currentNum *= stack.pop();
                    stack.push(currentNum);
                }
                else if(sign == '/'){
                    currentNum = stack.pop() / currentNum;
                    stack.push(currentNum);
                }
                sign = s.charAt(i);
                currentNum = 0;
            }
            i++;
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}

//class Solution {
//
//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java " + Runtime.version().feature());
//
//
//    }
//}

//public class Solution {
//
//    static public class Node{
//        char val;
//        Node left;
//        Node right;
//        Node(char v){val = v;}
//    }
//
//
//    static public class method {
//        static HashMap<Integer, StringBuilder> map;
//        static int min;
//        static int max;
//
//        static public String method(Node root){
//            if(root == null){
//                return "";
//            }
//            StringBuilder result = new StringBuilder();
//            map = new HashMap<>();
//            min = 0;
//            max = 0;
//            dfsHelper(root, 0);
//            for(int i = min; i <= max; i++){
//                result.append(map.get(i).toString());
//            }
//
//            return result.toString();
//        }
//
//        static private void dfsHelper(Node root, int colPosition){
//            if(root == null){
//                return;
//            }
//            min = Math.min(min, colPosition);
//            max = Math.max(max, colPosition);
//            StringBuilder tempRes = map.getOrDefault(colPosition, new StringBuilder());
//            tempRes.append(root.val);
//            map.put(colPosition, tempRes);
//            dfsHelper(root.left, colPosition - 1);
//            dfsHelper(root.right, colPosition + 1);
//        }
//    }
//
//
//
//
//    public static void main(String[] args) {
//        Node a = new Node('a');
//
//        Node b = new Node('b');
//
//        Node c = new Node('c');
//        Node d = new Node('d');
//        Node e = new Node('e');
//        Node f = new Node('f');
//
//        a.left = b;
//        a.right = c;
//
//        b.left = d;
//
//        b.right = e;
//
//        c.left = f;
//
//
//
//        System.out.println(method.method(a));
//
//    }
//}