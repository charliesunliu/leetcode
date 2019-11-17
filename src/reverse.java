class reverse {
    public int reverse(int x) {
        int y = 0;
        while (x != 0){
            y += x%10;
            y *= 10;
            x = x/10;
        }

        return y;
    }
}