import java.util.ArrayList;
import java.util.List;

class combinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        if(n > 45){
            return result;
        }

        combinationSumHelper(1, k, n, result, current);
        return result;
    }
    private void combinationSumHelper(int i, int k, int n, List<List<Integer>> result, ArrayList<Integer> current){
        if (n == 0 && k == 0){
            result.add((List<Integer>)current.clone());
            return;
        }
        if (n < 0){
            return;
        }
        while (i <= 9){
            current.add(i);
            combinationSumHelper(i+1, k - 1, n - i, result, current);
            current.remove(current.size() -1 );
            i++;
        }
    }
}