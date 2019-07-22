import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class groupStrings {
    public List<List<String>> groupStrings(String[] strings) {

        HashMap<String, List<String>> map = new HashMap<>();


        for (String str : strings){
            String pattern = "-";
            int offset = str.charAt(0) - 'a';
            for (int i = 0; i < str.length(); i++){
                char c = (char) (str.charAt(i) - offset);
                if(c < 'a'){
                    c += 'a';
                }
                pattern += c;
            }


            if (map.containsKey(pattern)){
                map.get(pattern).add(str);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(pattern, temp);
            }

        }

        ArrayList<List<String>> result = new ArrayList<>();
        result.addAll(map.values());

        return result;
    }
}