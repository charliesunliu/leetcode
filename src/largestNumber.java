import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class largestNumber {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new LargerNumberComparator());
        StringBuilder strb = new StringBuilder();
        for (String str : strNums) {
            strb.append(str);
        }
        return strb.toString();
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
}