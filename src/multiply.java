class multiply {
    public String multiply(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        if (num1.length() <= num2.length()){
            String tempHold = num1;
            num1 = num2;
            num2 = tempHold;
        }
        int carry = 0;
        for (int i = 0; i < num2.length(); i++){
            int currentOne = num1.charAt(num1.length() - i - 1) - '0';
            int currentTwo = num2.charAt(num2.length() - i - 1) - '0';

        }



        return result.toString();
    }
}