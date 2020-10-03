class isMatch {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        /*
         -a*.*dee
        -TFTFTFFF
        a
        b
        c
        d
        e
        e
        */
        /*
        1. s.(i) == p.(j) || p.(j) == '.';
            we check match[i-1][j-1]
        2. p.(j) == '*'
            2a: a* and a doesn't show at all
                we check match[i][j - 2]
            2b: a* and a appears
                we check match[i][j-1]
        */
        match[0][0] = true;
        for(int i = 1; i < p.length(); i++){
            if(p.charAt(i - 1) == '*'){
                match[0][i] = match[0][i - 2];
            }
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    match[i][j] = match[i-1][j-1];
                }
                if(p.charAt(j) == '*'){
                    match[i][j] = match[i][j - 2] || match[i][j-1];
                }
            }
        }


        return match[s.length()][p.length()];
    }
}