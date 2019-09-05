import java.util.ArrayList;
import java.util.List;

class getFactors {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n%i == 0){
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(i);
                getFHelper(result, cur, i, n/i);
                cur.remove(cur.size() - 1);
            }
        }
        return result;
    }

    private void getFHelper(List<List<Integer>> result, ArrayList<Integer> currentList, int currentInt, int target){
        if (target == 1){
            result.add((List<Integer>) currentList.clone());
            return;
        }
        for (int i = currentInt; i <= target; i++){
            if (target%i == 0 ){
                currentList.add(i);
                getFHelper(result, currentList, i, target/i);
                currentList.remove(currentList.size() - 1);
            }
        }

        return;
    }


}