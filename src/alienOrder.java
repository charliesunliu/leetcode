import java.util.*;

class alienOrder {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                if (!graph.containsKey(words[i].charAt(j))){
                    graph.put(words[i].charAt(j), new ArrayList<>());
                }
            }
        }

        for(int i = 0; i < words.length - 1; i++){

            char[] diff = firstDiff(words[i], words[i+1]);
            if (diff != null){
                List<Character> nextList = graph.getOrDefault(diff[0], new ArrayList<>());
                nextList.add(diff[1]);
                graph.put(diff[0], nextList);
            }
        }

        Stack<Character> stack = new Stack<>();
        HashSet<Character> visted = new HashSet<>();

        for (char k : graph.keySet()){
            if (!visted.contains(k)) {
                if (!toplogicalSort(graph, k, stack, visted, new HashSet<>())){
                    return "";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    private char[] firstDiff(String s1, String s2){
        for(int i = 0; i < Math.min(s1.length(), s2.length()); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 != c2){
                return new char[]{c1, c2};
            }
        }
        return null;
    }

    private boolean toplogicalSort(HashMap<Character, List<Character>> graph, char c, Stack<Character> stack, HashSet<Character> visted, HashSet<Character> circle){
        if(!graph.containsKey(c)){
            visted.add(c);
            stack.push(c);
        }

        if (circle.contains(c)){
            return false;
        }
        circle.add(c);
        boolean noCircle = true;
        for (char next : graph.get(c)){
            if (!visted.contains(next)){
                noCircle = noCircle && toplogicalSort(graph, next, stack,visted, circle);
            }
        }
        circle.remove(c);
        visted.add(c);
        stack.push(c);
        return noCircle;
    }
}