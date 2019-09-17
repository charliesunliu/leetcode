import java.util.ArrayList;

class getPermutation {
    public String getPermutation(int n, int k) {
        StringBuffer result = new StringBuffer();
        ArrayList nums = new ArrayList();
        for (int i = 1; i<= n; i++){
            nums.add(i);
        }

        while (nums.size() != 0){
            int fac = getFactorial(n);
            int fac_ = fac/n;
            int cat = (k - 1) / fac_;
            result.append(nums.get(cat));
            nums.remove(cat);
            n--;
            k = k - cat * fac_;
        }

        return result.toString();

    }
    private int getFactorial(int n){
        int result = 1;
        while (n > 1){
            result = result * n;
            n--;
        }
        return result;
    }
}