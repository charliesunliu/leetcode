import java.util.ArrayList;

class countAndSay {
    public String countAndSay(int n) {
        ArrayList<String> l = new ArrayList<>();
        l.add("1");
        for (int i = 1; i < n; i++){
            String line = "";
            String pre = l.get(i-1);
            int counter = 0;
            char current = pre.charAt(0);
            for (int j = 0; j < pre.length(); j++){
                if (current != pre.charAt(j)){
                    line = line + Integer.toString(counter) + current;
                    counter = 1;
                    current = pre.charAt(j);
                } else {
                    counter++;
                }
            }
            line = line + counter + current;
            l.add(line);
        }

        return l.get(n-1);

    }
}