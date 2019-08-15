import java.util.ArrayList;
import java.util.List;

class combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        combineHelper(1, n, k, (ArrayList<Integer>) current, result);

        return result;
    }
    private void combineHelper(int i,int n, int k, ArrayList<Integer> current, List<List<Integer>> result){
        if (k == 0){
            result.add((List<Integer>) current.clone());
            current.remove(current.size()-1);
            return;
        }
        if (i == n){
            return;
        }
        while (i < n){
            current.add(i);
            combineHelper(i, n, k-1, current, result);
            current.remove(current.size()-1);
            i++;
        }
        return;
    }
}