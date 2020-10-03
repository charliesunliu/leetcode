import java.util.LinkedList;
import java.util.List;

class removeInvalidParentheses {
    int longest = Integer.MIN_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        helper(s, 0, 0, -1, new StringBuilder(), result);
        return result;
    }
    private void helper(String s, int sum, int pointer, int lastAppend, StringBuilder sb, List<String> result){

        if(pointer >= s.length()){
            if(sum == 0 && sb.toString().length() >= longest) {
                longest = sb.toString().length();
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(pointer);

        if(c != '(' && c != ')'){
            sb.append(c);
            helper(s, sum, pointer + 1, pointer, sb, result);
            sb.setLength(sb.length() - 1);
            return;
        }

        if(c == '('){
            if(pointer == 0 || s.charAt(pointer - 1) == '(' && lastAppend == pointer - 1 || s.charAt(pointer - 1) != '('){
                sb.append(c);
                helper(s, sum + 1, pointer + 1, pointer, sb, result);
                sb.setLength(sb.length() - 1);
            }
            helper(s, sum, pointer + 1, lastAppend, sb, result);
        } else{
            if(sum == 0){
                helper(s, sum, pointer + 1, lastAppend, sb, result);
            }else{
                if(s.charAt(pointer - 1) == ')' && lastAppend == pointer - 1 || s.charAt(pointer - 1) != ')'){
                    sb.append(c);
                    helper(s, sum - 1, pointer + 1, pointer, sb, result);
                    sb.setLength(sb.length() - 1);
                }

                helper(s, sum, pointer + 1, lastAppend, sb, result);
            }
        }
    }
}