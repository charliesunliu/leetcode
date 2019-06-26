class getHint {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secNum = new int[10];
        int[] gusNum = new int[10];
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                secNum[s] ++;
                gusNum[g] --;
            }
        }
        for (int i = 0; i < 10; i ++){
            cows += Math.min(secNum[i], gusNum[i]);
        }
        return bulls + "A" + cows + "B";
    }
}