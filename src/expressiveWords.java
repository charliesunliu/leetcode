import java.util.ArrayList;

class expressiveWords {
    public int expressiveWords(String S, String[] words) {
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            if (chars.size() == 0 || S.charAt(i) != chars.get(chars.size() - 1)){
                chars.add(S.charAt(i));
                count.add(1);
            } else{
                count.set(count.size() - 1, count.get(count.size() - 1) + 1);
            }
        }

        int result = 0;
        for (String word : words){
            int wordIndex = 0;
            boolean flag = true;
            for (int i = 0; i < chars.size(); i++){
                int currentCount = 0;
                while (wordIndex < word.length() && word.charAt(wordIndex) == chars.get(i))
                {
                    wordIndex++;
                    currentCount++;
                }

                if ((currentCount != count.get(i) && currentCount >= count.get(i) - 1) || currentCount == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }


        return result;
    }
}