import java.util.Arrays;
import java.util.Collections;

public class maximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE; //or -1
        int max = Integer.MIN_VALUE; //or -1
        for(int i : nums) { //if you need to know the index, use int (i=0;i<array.length;i++) instead
            if(i < min) min = i; //or if(min == -1 || array[i] < array[min]) min = i;
            if(i > max) max = i; //or if(max == -1 || array[i] > array[max]) max = i;
        }

        int buckSize = (int)Math.ceil((double)(max - min)/(nums.length - 1));//Math.max(1, (max - min) / (nums.length - 1));
        int buckNum  = nums.length - 1;
        int[] buckMax = new int[buckNum];
        int[] buckMin = new int[buckNum];
        int[] buckUsed = new int[buckNum];

        for (int i = 0; i < buckNum; i++){
            buckMax[i] = Integer.MIN_VALUE;
            buckMin[i] = Integer.MAX_VALUE;
        }

        for (int num : nums){
            if (num == min || num == max){
                continue;
            }
            int buckIndex = (num - min) / buckSize;
            buckMax[buckIndex] = Math.max(buckMax[buckIndex], num);
            buckMin[buckIndex] = Math.min(buckMin[buckIndex], num);
            buckUsed[buckIndex] = 1;
        }

        int maxGap = Integer.MIN_VALUE;
        int preMax = min;
        for (int i = 0; i < buckNum - 1; i++) {
            if (buckUsed[i] == 1){
                if (preMax != -1){
                    maxGap = Math.max(maxGap, buckMin[i] - preMax);
                }
                preMax = buckMax[i];

            }
        }
        maxGap = Math.max(maxGap, max - preMax);
        return maxGap;
    }
}
