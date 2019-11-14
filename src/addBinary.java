class addBinary {
    public String addBinary(String a, String b) {
        String longOne = new String();
        String shortOne = new String();
        StringBuffer result = new StringBuffer();

        if(a.length() > b.length()){
            longOne = a;
            shortOne = b;
        }else {
            longOne = b;
            shortOne = a;
        }
        int i;
        int carry = 0;
        for(i = 0; i < shortOne.length(); i++){
            int s = shortOne.charAt(shortOne.length() - 1 - i) - '0';
            int l = longOne.charAt(shortOne.length() - 1 - i) - '0';
            int current = s + l + carry;
            if (current == 3){
                result.insert(0, '1');
                carry = 1;
            } else if (current == 2){
                result.insert(0, '0');
                carry = 1;
            } else if (current == 1){
                result.insert(0, '1');
                carry = 0;
            } else {
                result.insert(0, '0');
                carry = 0;
            }
        }
        for (i = i; i < longOne.length(); i++){
            int l = longOne.charAt(shortOne.length() - 1 - i) - '0';
            int current = l + carry;
            if (current == 2){
                result.insert(0, '0');
                carry = 1;
            } else if (current == 1){
                result.insert(0, '1');
                carry = 0;
            } else {
                result.insert(0, '0');
                carry = 0;
            }
        }
        if (carry == 1){
            result.insert(0, '1');
        }
        return result.toString();
    }
}