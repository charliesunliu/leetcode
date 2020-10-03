import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class shortestWay {
    public int shortestWay(String source, String target) {
        int result = 1;

        HashMap<Character, ArrayList<Integer>> indexMap = new HashMap<>();
        int[] charIndex = new int[26];

        for (int i = 0; i < source.length(); i++){
            ArrayList indexList = indexMap.getOrDefault(source.charAt(i), new ArrayList<Integer>());
//            if (indexList.size() == 0){
//                charIndex[source.charAt(i) - 'a'] = i;
//            }
            indexList.add(i);
            indexMap.put(source.charAt(i), indexList);
        }
        int currentSourceIndex = -1;
        for (int i = 0; i < target.length(); i++){
            char currentChar = target.charAt(i);

            if (indexMap.get(currentChar) == null){
                return -1;
            }
            // charIndex for char a >= size of the char a on the indexMap
            while (charIndex[currentChar - 'a'] < indexMap.get(currentChar).size() && indexMap.get(currentChar).get(charIndex[currentChar - 'a']) <= currentSourceIndex){
                charIndex[currentChar - 'a']++;
            }

            if (charIndex[currentChar - 'a'] >= indexMap.get(currentChar).size()){
//                int a1 = charIndex[currentChar - 'a'];
//                int a2 = indexMap.get(currentChar).size();
//                int b1 = indexMap.get(currentChar).get(charIndex[currentChar - 'a']);
//                int b2 = currentSourceIndex;

                result++;
                Arrays.fill(charIndex, 0);
            }
            currentSourceIndex = indexMap.get(currentChar).get(charIndex[currentChar - 'a']);
            charIndex[currentChar - 'a']++;

        }

        return result;
    }
}