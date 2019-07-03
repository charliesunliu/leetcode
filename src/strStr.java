public class strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()){
            return -1;
        }
        if (needle.equals("")){
            return 0;
        }
        for (int i = 0; i + needle.length() <= haystack.length(); i++){
            if (haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }

        return -1;

    }

}
