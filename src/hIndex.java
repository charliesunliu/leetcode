import java.lang.reflect.Array;
import java.util.Arrays;

class hIndex {
    public int hIndex(int[] citations) {
        int[] sorted = new int[citations.length];

        int tot = 0;
        for (int i = 0; i < citations.length; i++){

            if (citations[i] >= citations.length){
                sorted[sorted.length-1]++;
            }else {
                sorted[citations[i]]++;
            }
        }

        for (int i = sorted.length - 1; i >= 0; i--){
            tot+= sorted[i];
            if (tot >= i){
                return i;
            }
        }

        return 0;
    }
}