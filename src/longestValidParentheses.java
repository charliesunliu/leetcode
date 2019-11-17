import java.util.Stack;

class longestValidParentheses {
    public int longestValidParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (c == ')'){
                if (!stack.empty() && stack.peek() == '('){
                    stack.pop();
                    current+=2;
                    result = Math.max(current, result);
                }
            }
            else{
                stack.push(c);
            }

        }

        return 0;
    }
}