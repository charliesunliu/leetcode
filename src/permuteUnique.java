import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        ArrayList<Integer> cur = new ArrayList();

        perHelper(result, cur, nums, used);

        return result;
    }
    private void perHelper(List<List<Integer>> result, ArrayList<Integer> cur, int[] nums, int[] used){
        if (cur.size() == nums.length){
            result.add((List<Integer>) cur.clone());
        }

        for (int i = 0; i < used.length; i++){
            if (used[i] == 0){
                if ((i > 0 && nums[i] == nums[i-1] && used[i-1] != 1) || used[i] == 1){
                    continue;
                }
                else {
                    cur.add(nums[i]);
                    used[i] = 1;
                    perHelper(result, cur, nums, used);
                    cur.remove(cur.size()-1);
                    used[i] = 0;
                }
            }
        }

        return;

    }
}