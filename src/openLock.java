import java.util.Arrays;
import java.util.HashSet;

class openLock {
    HashSet<String> endsmap = new HashSet<>();
    public int openLock(String[] deadends, String target) {

        endsmap.addAll(Arrays.asList(deadends));

        int[] lock = new int[4];
        return helper(lock, 0, target, deadends);
    }
    private int helper(int[] lock, int result, String target, String[] deadends){
        System.out.println(Arrays.toString(lock));
        if (match(lock, target)){
            return result;
        }
//        if (end(lock, deadends)){
//            return -1;
//        }
        int currentResult = Integer.MAX_VALUE;
        boolean canReach = false;
        for (int i = 0; i < 4; i ++){
            int up = -1; int down = -1;
            if (lock[i] < 9){
                lock[i] = lock[i] + 1;
                if (!end(lock, deadends)){
                    up = helper(lock, result+1, target, deadends);
                }
                lock[i] = lock[i] - 1;
            }
            if (lock[i] == 0){
                lock[i] = 9;
                if (!end(lock, deadends)){
                    down = helper(lock, result+1, target, deadends);
                }
                lock[i] = 0;
            }else {
                lock[i] = lock[i] - 1;
                down = helper(lock, result+1, target, deadends);
                lock[i] = lock[i] + 1;
            }
            if (up != -1){
                currentResult = Math.min(currentResult, up);
                canReach = true;
            }
            if (down != -1){
                currentResult = Math.min(currentResult, down);
                canReach = true;
            }
        }
        if (canReach){
            return currentResult;
        }
        return -1;
    }
    private boolean end(int[] lock, String[] deadends){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4;i++){
            buffer.append(lock[i]);
        }
        if (endsmap.contains(buffer.toString())){
            return true;
        } else {
            endsmap.add(buffer.toString());
            return false;
        }
    }
    private boolean match(int[] lock, String target){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4;i++){
            buffer.append(lock[i]);
        }
        return target.equals(buffer.toString());
    }

}