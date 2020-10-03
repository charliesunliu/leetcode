import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class findDuplicateII {
    public List<List<String>> findDuplicateII(String[] paths) {
        //MessageDigest.getInstance("MD5");
        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String path : paths){
            String[] files = path.split(" ");
            for(int i = 0; i < files.length; i++){
                if (files[i].contains(".")){
                    String content = files[i].substring(files[i].indexOf('('),files[i].indexOf(')'));
                    if (!map.containsKey(content)){
                        map.put(content, new ArrayList<>());
                    }
                    map.get(content).add(files[0] + '/' + files[i].substring(0,files[i].indexOf('(')));
                }
            }
        }

        for(List<String> files : map.values()){
            if (files.size() > 1){
                result.add(files);
            }
        }
        return result;
    }
}