import java.util.HashSet;
import java.util.List;

class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int maxL = 0;
        for (String w : wordDict){
            if (w.length() > maxL){
                maxL = w.length();
            }
            set.add(w);
        }

        boolean[] list = new boolean[s.length()+1];
        list[0] = true;
        for (int i = 0; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (i - j > maxL){
                    continue;
                }
                if (list[j] && set.contains(s.substring(j, i))){
                    list[i] = true;
                    break;
                }
            }
        }


        return list[s.length()];

    }

    private boolean wbHelper(String s, HashSet<String> set, int maxL){
        if (s.length() < maxL && set.contains(s)){
            return true;
        }

        boolean result = false;

        for (int i = 0; i < s.length(); i++){
            if (i > maxL){
                return result;
            }
            System.out.println(s.length());
            if (set.contains(s.substring(0, i+1))){
                if (i + 1 >= s.length()){
                    return result;
                }
                else {
                    result = result || wbHelper(s.substring(i+1), set, maxL);
                }
            }
        }

        return result;
    }
}