import java.util.Stack;

class longestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[s.length()];
        int result = 0;

        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (c == '('){
                stack.push(i);
            }

            if (c == ')'){
                int currentLength = 0;
                if (!stack.isEmpty()){
                    currentLength+=2;
                    int lastLeft = stack.pop();
                    if (lastLeft - 1 >= 0){
                        currentLength += results[lastLeft - 1];
                    }
                    currentLength += results[i-1];
//                    if (lastLeft + 1 < s.length()){
//                        currentLength += results[lastLeft + 1];
//                    }
                    results[lastLeft] = currentLength;
                    results[i] = currentLength;
                    result = Math.max(result, currentLength);
                }
            }
        }

        return result;


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
