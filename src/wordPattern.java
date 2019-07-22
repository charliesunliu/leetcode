import java.util.HashMap;

class wordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strList = str.split(" ");

        if (strList.length < pattern.length() || strList.length > pattern.length()){
            return false;
        }
        HashMap<Character, String> match = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if (!match.containsKey(c) && !match.containsValue(strList[i]) ){
                match.put(c, strList[i]);
            }
            if (!match.getOrDefault(c,"").equals(strList[i])){
                return false;
            }
        }


        return true;
    }
}