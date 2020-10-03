import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class isPossible {
    public boolean isPossible(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if (numList.size() == 0 || numList.get(numList.size() - 1) != nums[i]){
                numList.add(nums[i]);
                countList.add(1);
            } else {
                countList.set(countList.size() - 1, countList.get(countList.size() - 1) + 1);
            }
        }

        List<List<Integer>> candidates = new ArrayList<>();
        for(int i = 0; i < numList.size(); i++){
            int count = countList.get(i);

            for (int j = candidates.size() - 1; j >= 0; j++){
                List<Integer> candidate = candidates.get(j);
                if (candidate.get(candidate.size() - 1) + 1 == numList.get(i) && count > 0){
                    candidate.add(numList.get(i));
                    count--;
                }
            }

            while (count > 0){
                count--;
                List<Integer> newCandidate = new ArrayList<>();
                newCandidate.add(numList.get(i));
                candidates.add(newCandidate);
            }

            Iterator<List<Integer>> listI = candidates.iterator();
            while (listI.hasNext()){
                List<Integer> currentList = listI.next();
                if (currentList.get(currentList.size() - 1) != numList.get(i)){
                    if (currentList.size() >= 3){
                        listI.remove();
                    } else {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }

        for (List<Integer> candidate : candidates){
            if (candidate.size() <= 3){
                return false;
            }
        }
        return true;
    }
}