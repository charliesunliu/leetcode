import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class maximumSwap {
    public int maximumSwap(int num) {

        int or = num;
        List<Integer> nums = new ArrayList<>();
        while (num > 0){
            int currentDigit = num % 10;
            nums.add(0, currentDigit);
            num /= 10;
        }
        int[][] largest = new int[nums.size()][2];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.size(); i++){
            int currentDigit = nums.get(nums.size() - 1 - i);
            if (max < currentDigit){
                max = currentDigit;
                maxIndex = nums.size() - 1 - i;
            }
            largest[nums.size() - 1 - i][0] = max;largest[nums.size() - 1 - i][1] = maxIndex;
        }

        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) < largest[i][0]){
                nums.set(largest[i][1], nums.get(i));
                nums.set(i, largest[i][0]);
                int result = 0;
                for (int j = 0; j < nums.size(); j++){
                    result *= 10;
                    result += nums.get(j);
                }
                return result;
            }

        }


        return or;
    }
}