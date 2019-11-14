class minimumSwap {
    public int minimumSwap(String s1, String s2) {
        int result = 0;
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                if (s1.charAt(i) == 'x'){
                    xy++;
                } else {
                    yx++;
                }
            }
        }
        result+=xy/2 + yx/2;
        if (xy % 2 != yx % 2){
            return -1;
        }
        if (xy%2 == 1){
            result+=2;
        }

        return result;
    }
}