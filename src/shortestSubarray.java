import java.util.ArrayDeque;
import java.util.Deque;

class shortestSubarray {
    public int shortestSubarray(int[] A, int K) {
        int[] curSum = new int[A.length];
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            curSum[i] = sum;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int minLength = curSum.length + 1;
        for (int i = 0; i < curSum.length; i++){
            if(dq.isEmpty()){
                dq.add(i);
            }else{
                while (!dq.isEmpty() && curSum[dq.peekLast()] >= curSum[i]) {
                    dq.removeLast();
                }
                while (!dq.isEmpty() && curSum[i] - curSum[dq.peekFirst()] >= K){
                    minLength = Math.min(minLength, i - dq.peekFirst());
                    dq.removeFirst();
                }
                dq.addLast(i);
            }
        }
        return minLength;
    }
}