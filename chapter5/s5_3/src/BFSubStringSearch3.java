/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 */
public class BFSubStringSearch3 {
    private String pat;
    private int M;
    public BFSubStringSearch3(String pat)
    {
        this.pat = pat;
        M = pat.length();
    }
    public int search(String txt)
    {
        int i, j, N = txt.length();

        for(i = 0; i < N - M + 1; ++i)
        {
            for(j = 0; j < M; ++j)
                if(txt.charAt(i + j) != pat.charAt(j))
                    break;
            if(j == M)
                return i;
        }
        return N;
    }
}
