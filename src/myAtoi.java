class myAtoi {
    public int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }
        long result = 0;
        int flag = 1;
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' '){
            index++;
        }
        if(index >= str.length()){
            return 0;
        }
        if (str.charAt(index) == '-'){
            flag = -1;
            index++;
        }
        if(index >= str.length() || (str.charAt(index) > '9' || str.charAt(index) < '0')){
            return 0;
        }
        StringBuffer num = new StringBuffer();
        int indexEnd = index;
        while (indexEnd < str.length() && (str.charAt(indexEnd) <= '9' && str.charAt(indexEnd) >= '0')){
            num.append(str.charAt(indexEnd));
            indexEnd++;
        }
        if (num.length() == 0){
            return 0;
        }
        result = Long.valueOf(num.toString()) * flag;
        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;

    }
}