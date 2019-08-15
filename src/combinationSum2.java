import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> current = new ArrayList<>();

            combineHelper(0, candidates, target, 0, (ArrayList<Integer>) current, result);

            return result;
        }
        private void combineHelper(int i,int[] candidates, int target, int sum, ArrayList<Integer> current, List<List<Integer>> result){
            if (sum == target){
                result.add((List<Integer>) current.clone());
                return;
            }
            while (i < candidates.length){

                current.add(candidates[i]);
                i++;
                if (i < candidates.length && candidates[i] == candidates[i-1]){
                    current.remove(current.size()-1);
                    continue;
                }
                combineHelper(i, candidates, target, sum+candidates[i-1], current, result);
                current.remove(current.size()-1);
            }
        }
}