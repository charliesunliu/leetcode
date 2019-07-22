class reverseWords {
    public String reverseWords(String s) {
        String result = "";

        String[] strArr = s.split("\\s+");

        for (int i = strArr.length - 1; i >= 0; i--){
            result += strArr[i];
            result += " ";
        }

        return result.substring(0, result.length() - 1);
    }
}