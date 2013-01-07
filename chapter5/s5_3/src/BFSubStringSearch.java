/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午6:11
 * To change this template use File | Settings | File Templates.
 */
public class BFSubStringSearch {
    public static int search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        for(int i = 0; i <= N - M; ++i)
        {
            int j;
            for(j = 0; j < M; ++j)
                if(txt.charAt(i + j) != pat.charAt(j))
                    break;
            if(j == M)
                return i;
        }
        return N;
    }
}
