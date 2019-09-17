import java.util.ArrayList;
import java.util.List;

class generateAbbreviations {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        helper(result, word, new StringBuffer(), 0,0);


        return result;
    }
    private void helper(List<String> result, String word, StringBuffer current, int position, int level){
        if(position == word.length()){
            if (level != 0)current.append(level);
            result.add(current.toString());
            return;
        }
        int l = current.length();
        //Not Append
        helper(result, word, current,position+1, level+1);

        //Append
        if (level != 0) current.append(level);
        current.append(word.charAt(position));
        helper(result, word, current, position+1, level);

        current.setLength(l);
    }
}