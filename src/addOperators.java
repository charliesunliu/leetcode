import java.util.LinkedList;
import java.util.List;

class addOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();

        addHelper(result, num, 0, target, 0, 0, new StringBuilder());

        return result;
    }
    private void addHelper(List<String> result, String num, int pointer, int target, int res, int preVal, StringBuilder sb){
        if (pointer >= num.length()){
            if (res == target) result.add(sb.toString());
            return;
        }
        for (int i = pointer; i < num.length(); i++){
            if (i != pointer && num.charAt(pointer) == '0'){
                return;
            }
            int currentVal = Integer.parseInt(num.substring(pointer, i + 1));
            if (pointer == 0){
                addHelper(result, num, i, target, res + currentVal, currentVal, new StringBuilder(sb).append(currentVal));
            }
            else {

                addHelper(result, num, i, target, res + currentVal, currentVal, new StringBuilder(sb).append('+').append(currentVal));

                addHelper(result, num, i, target, res - currentVal, -currentVal, new StringBuilder(sb).append('-').append(currentVal));

                addHelper(result, num, i, target, res - preVal + preVal * currentVal, preVal * currentVal, new StringBuilder(sb).append('*').append(currentVal));
            }
        }
    }
}