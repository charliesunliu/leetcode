class isOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t) || Math.abs(s.length() - t.length()) > 1){
            return false;
        }
        if (t.length() > s.length()){
            int i = 0;
            int j = 0;
            int flag = 0;
            while (i < s.length() && j < t.length()){
                if (s.charAt(i) == t.charAt(j)){
                    i++;
                    j++;
                }else{
                    if (flag == 0){
                        flag = 1;
                        j++;
                    }else {
                        return false;
                    }
                }
            }
        }
        if (t.length() < s.length()){
            int i = 0;
            int j = 0;
            int flag = 0;
            while (i < s.length() && j < t.length()){
                if (s.charAt(i) == t.charAt(j)){
                    i++;
                    j++;
                }else{
                    if (flag == 0){
                        flag = 1;
                        i++;
                    }else {
                        return false;
                    }
                }
            }
        }
        if (t.length() == s.length()){
            int i = 0;
            int j = 0;
            int flag = 0;
            while (i < s.length() && j < t.length()){
                if (s.charAt(i) == t.charAt(j)){
                    i++;
                    j++;
                }else{
                    if (flag == 0){
                        flag = 1;
                        i++; j++;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}