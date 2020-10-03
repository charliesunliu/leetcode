import java.util.*;

class accountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, String> emailName = new HashMap<>();
        for (List<String> account : accounts){
            for (int i = 0; i < account.size(); i++){
                if (i == 0){
                    emailName.putIfAbsent(account.get(1), account.get(0));
                }
                List<String> l1 = map.getOrDefault(account.get(i), new LinkedList<>());
                l1.add(account.get(0));
                map.put(account.get(i), l1);
                map.get(account.get(0)).add(account.get(i));
            }
        }
        HashSet<String> visited = new HashSet<>();

        List<List<String>> result = new LinkedList<>();

        for (String email : emailName.keySet()){
            if (visited.contains(email)){
                continue;
            }
            Stack<String> stack = new Stack<>();
            List<String> account = new LinkedList<>();
            stack.push(email);
            visited.add(email);
            while (!stack.isEmpty()){
                String current = stack.pop();
                account.add(current);
                for (String otherEmail : map.get(current)){
                    if (!visited.contains(otherEmail)){
                        stack.push(otherEmail);
                        visited.add(otherEmail);
                    }
                }
            }
            Collections.sort(account);
            account.add(0, emailName.get(email));
            result.add(account);
        }

        return result;
    }
}