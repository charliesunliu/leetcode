import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class advantageCount {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);
        ArrayList<Integer> smaller = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (Integer num : B){
            if (!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }
        }
        int i =0; int j = 0;
        while(i < A.length){
            if(A[i] > sortedB[j]){
                map.get(sortedB[j]).add(A[i]);
                i++; j++;
            } else{
                smaller.add(A[i]);
                i++;
            }
        }

        for(int k = 0; k < B.length; k++){
            if(map.containsKey(B[k])){
                B[k] = map.get(B[k]).get(0);
                map.get(B[k]).remove(0);
                if(map.get(B[k]).size() == 0){
                    map.remove(B[k]);
                }
            } else{
                B[k] = smaller.get(0);
                smaller.remove(0);
            }
        }

        return B;
    }
}