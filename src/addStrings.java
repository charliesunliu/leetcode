class addStrings {
    public String addStrings(String num1, String num2) {
//         if(num.length() == 0 ){

//         }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--){
            int x, y;
            if (i >= 0){
                x = num1.charAt(i) - '0';
            } else {
                x = 0;
            }
            if (j >= 0){
                y = num2.charAt(j) - '0';
            } else {
                y = 0;
            }

            int current = x + y + carry;
            carry = 0;
            if (current >= 10){
                carry = 1;
            }
            result.append(current % 10);
        }
        if(carry == 1){
            result.append(1);
        }

        return result.reverse().toString();
    }
}