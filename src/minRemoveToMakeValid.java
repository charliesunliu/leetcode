import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class minRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                dq.add(i);
            }
            if (s.charAt(i) == ')'){
                 if(dq.isEmpty() || s.charAt(dq.peekLast()) != '('){
                    dq.add(i);
                } else {
                     dq.pollLast();
                 }
            }
        }
        //System.out.println(dq.toString());
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            if (!dq.isEmpty() && i == dq.peekFirst()){
                dq.pollFirst();
                continue;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}