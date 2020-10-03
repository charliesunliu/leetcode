import java.util.LinkedList;
import java.util.List;

class generatePalindromes {
    public List<String> generatePalindromes(String s) {
        int[] chars = new int[128];
        List<String> result = new LinkedList<>();
        int odd = -1;
        for (int i = 0; i<s.length(); i++){
            chars[(int)s.charAt(i)]++;
        }
        int resultLength = 0;
        for (int i = 0; i < 128; i++){
            if (chars[i] % 2 != 0){
                if (odd != -1){
                    return result;
                }
                odd = i;
            }
            resultLength += chars[i];
            chars[i] = chars[i] / 2;
        }
        resultLength /= 2;
        generatePermutation(result, new StringBuilder(), chars, resultLength, odd);

        return result;
    }

    private void generatePermutation(List<String> result, StringBuilder tempStr, int[] chars, int resultLength, int odd){
        if (tempStr.length() == resultLength){

            StringBuilder tempResult = new StringBuilder(tempStr);
            if (odd != -1){
                tempResult.append((char)odd);
            }
            StringBuilder reserved = new StringBuilder(tempStr);
            tempResult.append(reserved.reverse());
            result.add(tempResult.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != 0){
                tempStr.append((char) (i));
                System.out.println(tempStr.length());
                chars[i]--;
                generatePermutation(result, tempStr, chars, resultLength, odd);
                tempStr.setLength(tempStr.length() - 1);
                chars[i]++;
            }
        }
    }
}

/*
    public List<String> generatePalindromes(String s) {
        int[] chars = new int[2];
        List<String> result = new LinkedList<>();
        int odd = -1;
        for (int i = 0; i<s.length(); i++){
            chars[(int)s.charAt(i)]++;
        }
        int resultLength = 0;
        for (int i = 0; i < 128; i++){
            if (chars[i] % 2 != 0){
                if (odd != -1){
                    return result;
                }
                odd = i;
            }
            resultLength += chars[i];
            chars[i] = chars[i] / 2;
        }
        resultLength /= 2;
        generatePermutation(result, new StringBuilder(), chars, resultLength, odd);

        return result;
    }

    private void generatePermutation(List<String> result, StringBuilder tempStr, int[] chars, int resultLength, int odd){
        if (tempStr.length() == resultLength){
            if (odd != -1){
                tempStr.append((char)odd);
            }

            tempStr.append(tempStr.reverse());
            result.add(tempStr.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != 0){
                tempStr.append((char) i);
                System.out.println(tempStr.length());
                chars[i]--;
                generatePermutation(result, tempStr, chars, resultLength, odd);
                tempStr.setLength(tempStr.length() - 1);
                chars[i]++;
            }
        }
    }
 */