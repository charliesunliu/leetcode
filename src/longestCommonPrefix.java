public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1){
            return "";
        }


        String prefix = "";
        prefix = strs[0];
        for (String s : strs){
            int i = 0;
            while (i < prefix.length() && i < s.length()&& s.charAt(i) == prefix.charAt(i)){
                i++;
            }
            prefix = prefix.substring(0, i);
        }

        return prefix;
    }
}
