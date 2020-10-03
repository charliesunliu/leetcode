class smallestRepunitDivByK {
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0 || K % 5==0){
            return -1;
        }
        int r = 0;
        int result = 0;
        do {
            r = r * 10 + 1;
            r = r % K;
            result++;
        }while (r!=0);
        return result;
    }
}