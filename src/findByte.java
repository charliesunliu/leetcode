public class findByte
{
    //private long patHash; // pattern hash value
    private long Q; // modulus
    private int R; // radix
    public findByte(int r, int q) {
        R = r;
        Q = q;//27449;
        //patHash = hash(pat, M);
    }
    private long hash(String key, int M)
    {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (h * R + key.charAt(j)) % Q;
        return h;
    }
    public int search(String txt, String pat)
    {
        int M = pat.length();
        long RM1 = 1;
        for (int i = 1; i <= M-1; i++)
            RM1 = (R * RM1) % Q;


        int N = txt.length();
        M = pat.length();
        long txtHash = hash(txt, M);
        long patHash = hash(pat, M);
        if (patHash == txtHash) return 0;
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM1 * txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) return i - M + 1;
        }
        return N;
    }
}