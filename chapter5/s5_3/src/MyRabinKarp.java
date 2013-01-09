/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午7:58
 * To change this template use File | Settings | File Templates.
 */
public class MyRabinKarp {
    private String pat;
    private long patHash;
    private int M;
    private long Q;
    private int R = 256;
    private long RM;

    public MyRabinKarp(String pat)
    {
        this.pat = pat;
       // Q = longRandomPrime();
        RM = 1;
        for(int i = 1; i < M; ++i)
            RM = (RM * R) % Q;
        patHash = hash(pat, M);
    }

    private long hash(String key, int M)
    {
        long h = 0;
        for(int i = 0; i < M; ++i)
            h = (h * R + key.charAt(i)) % Q;
        return h;
    }
    private boolean check(int i)
    {
        return true;
    }
    public int search(String txt)
    {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if(txtHash == patHash)
            return 0;
        for(int i = M; i < N; ++i)
        {
            txtHash = (txtHash - RM * txt.charAt(i - M) % Q + Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if(txtHash == patHash && check(i - M + 1))
                return i - M + 1;
        }
        return N;
    }
}
