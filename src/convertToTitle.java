class convertToTitle {
    public String convertToTitle(int n) {
        StringBuffer result = new StringBuffer();

        while (n != 0){
            char c = 'Z';
            if (n%26 != 0){
                c = (char) ('A' + n%26);
            }
            result.insert(0, c);
            result.append(c);
            n -= (c - 'A' + 1);
            n /= 26;
        }
        return result.toString();
    }
}