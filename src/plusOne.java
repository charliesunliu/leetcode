class plusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] newNumber = new int [digits.length+1];
        newNumber[0] = 1;

        return newNumber;
    }
}