import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        int counter = 0;
        StringBuffer header = new StringBuffer();

        for (String str : strs){
            counter++;
            header.append(str.length());
            header.append("-");
            sb.append(str);
        }




        return counter + "-" + header.toString() + ":" +sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int count = Integer.parseInt(s.substring(0,s.indexOf("-")));
        String strs = s.substring(s.indexOf(':'));
        String[] ls = s.split("-");
        List<String> result = new ArrayList<>();



        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));