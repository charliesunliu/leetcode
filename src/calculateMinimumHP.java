//174. Dungeon Game
class calculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {

        if (dungeon.length==0 || dungeon[0].length == 0){
            return 1;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] hpNeed = new int[m][n];

        for (int i = m - 1; i >= 0; i--){
            for(int j = n-1; j >=0;j--){
                if (i == m-1 && j == n-1){
                    hpNeed[i][j] = Math.abs(Math.min(dungeon[i][j]-1, 1));
                    if (hpNeed[i][j] == 0){
                        hpNeed[i][j]++;
                    }
                    continue;
                }
                int boti = i+1; int botj = j;
                int righti= i; int rightj = j+1;

                if (i == m-1){
                    hpNeed[i][j] = Math.max(hpNeed[righti][rightj] - dungeon[i][j], 1);
                    continue;
                }
                if (j == n-1){
                    hpNeed[i][j] = Math.max(hpNeed[boti][botj] - dungeon[i][j], 1);
                    continue;
                }

                int botRequireHP = hpNeed[boti][botj];
                int rightRequireHP = hpNeed[righti][rightj];

                int currentHP =Math.max(Math.min(botRequireHP, rightRequireHP) - dungeon[i][j] , 1);
                hpNeed[i][j] = currentHP;
            }
        }
        return hpNeed[0][0];
    }
}