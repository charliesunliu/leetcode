class titleToNumber {
    public int titleToNumber(String s) {
        int counter = 1;
        int num = 0;
        for(int i = s.length() - 1;i >= 0; i--){
            char c = s.charAt(i);
            num += counter* (c-'A' + 1);
            counter *= 26;
        }



        return num;
    }
}