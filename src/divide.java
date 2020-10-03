import java.util.LinkedList;
import java.util.List;

class divide {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
            sign = -1;
        }
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long)divisor);
        List<Long> multiplier = new LinkedList<>();
        List<Long> nums = new LinkedList<>();
        long result = 1; long num = divisorLong;
        multiplier.add(result);
        nums.add(num);
        while (num < dividendLong){
            result += result;
            num += num;
            multiplier.add(result);
            nums.add(num);
        }
        int i = multiplier.size() - 3;
        while (i >= 0 && num != dividendLong){
            if (num > dividendLong){
                result -= multiplier.get(i);
                num -= nums.get(i);
            } else{
                result += multiplier.get(i);
                num += nums.get(i);
            }
            i--;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }


        if (num > dividendLong){
            return sign*((int)result - 1);
        }
        return sign * (int)result;
    }
}