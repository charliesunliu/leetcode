import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class longestOnes {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        Queue<Integer> zeros = new LinkedList<>();
        if (A[right] == 0){
            zeros.add(right);
        }
        int result = 0;

        while (right < A.length - 1){
            while (zeros.size() > K){
                left = zeros.poll() + 1;
            }
            right++;
            if (A[right] == 0){
                zeros.add(right);
            }
            if (zeros.size() <= K){
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}