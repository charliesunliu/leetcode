class totalFruit {
    public int totalFruit(int[] tree) {
        int result = 0;
        int[] baskets = {-1, -1};
        int bk1 = 0;
        int lastBk1 = 0;
        int bk2 = 0;
        int lastBk2 = 0;
        for (int i = 0; i < tree.length; i++){

            if (baskets[0] == -1){
                baskets[0] = tree[i];
                lastBk1 = i;
                bk1++;
            } else if (baskets[0] != tree[i] && baskets[1] == -1){
                baskets[1] = tree[i];
                lastBk2 = i;
                bk2++;
            }
            else if (tree[i] == baskets[0]){
                bk1++;
                lastBk1 = i;
            }
            else if (tree[i] == baskets[1]){
                bk2++;
                lastBk2 = i;
            }
            else {
                if (lastBk2 > lastBk1){
                    bk2 = lastBk2 - lastBk1;
                    baskets[0] = tree[i];
                    lastBk1 = i;
                    bk1 = 1;
                } else {
                    bk1 = lastBk1 - lastBk2;
                    baskets[1] = tree[i];
                    lastBk2 = i;
                    bk2 = 1;

                }
            }
            result = Math.max(bk1 + bk2, result);
        }
        return  result;
    }
}