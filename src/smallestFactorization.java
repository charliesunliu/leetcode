class smallestFactorization {
    public int smallestFactorization(int a) {
        if(a==1){
            return 1;
        }
        long result = 0;
        long level = 1;
        while (a != 1){
            for (int i = 9; i >= 1; i--){
                if (i == 1){
                    return 0;
                }
                if (a % i == 0){
                    result += level * i;
                    level = level * 10;
                    a /= i;
                    break;
                }

            }
        }
        if (result > Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }
}