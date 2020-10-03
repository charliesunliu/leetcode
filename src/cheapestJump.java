import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class cheapestJump {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] value = new int[A.length];
        List<Integer>[] coins = new List[A.length];
        coins[0] = new LinkedList<>();
        coins[0].add(A[0]);
        value[0] = 1;
        for (int i = 1; i < A.length; i++){
            coins[i] = new LinkedList<>();
            value[i] = Integer.MAX_VALUE;
            if (A[i] == -1){
                value[i] = -1;
                continue;
            }
            for (int j = i - B; j < i; j++){
                if (j < 0 || A[j] < 0){
                    continue;
                }
                if (value[i] >= value[j] + A[i] && coins[j].size() > 0){
                    value[i] = value[j] + A[i];
                    coins[i] = new LinkedList<>(coins[j]);
                    coins[i].add(i + 1);
                }
            }
        }
        return coins[A.length - 1];
    }
}