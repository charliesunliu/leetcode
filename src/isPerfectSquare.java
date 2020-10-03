class isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <=2 && num > -1){
            return true;
        }
        int right = 2;
        int left = 2;
        while (right * right < num){
            if (right * right  == num){
                return true;
            }
            left = right;
            right = right * 2;

        }
        while (left < right){
            int mid = left + (right - left)/2;
            if (mid * mid == num){
                return true;
            }
            if (mid * mid > num){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}