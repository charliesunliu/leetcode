import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class lengthLongestPath {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLength = 0;
        stack.push(0);
        for (String s : input.split("\n")){
            int level = s.lastIndexOf('\t') + 1;
            while (level + 1 < stack.size()){
                stack.pop();
            }
            int len = stack.peek() + s.length()  - level + 1;
            if (s.contains(".")){
                maxLength = Math.max(maxLength, len);
            } else{
                stack.push(len);
            }
        }

        return maxLength;
    }
}