import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class findSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private void helper(LinkedList<Integer> currentRes, int index, int[] num, List<List<Integer>> result){
        if (currentRes.size() >= 2){
            result.add(new LinkedList<Integer>(currentRes));
        }
        HashSet<Integer> viewed = new HashSet<>();
        for (int i = index; i < num.length; i++){
            if (viewed.contains(num[i])) continue;
            if (currentRes.size() == 0 || num[i] >= currentRes.peek()){
                currentRes.add(num[i]);
                helper(currentRes, i + 1, num, result);
                viewed.add(num[i]);
                currentRes.remove(currentRes.size() - 1);
            }
        }
    }
}