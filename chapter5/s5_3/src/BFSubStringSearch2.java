/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午6:26
 * To change this template use File | Settings | File Templates.
 */
public class BFSubStringSearch2 {
    public static int search(String pat, String txt)
    {
        int N = txt.length();
        int M = pat.length();
        int j, i;
        for(i = 0, j = 0; i < N && j < M; ++i)
        {
            if(txt.charAt(i) != pat.charAt(j))
            {
                i -= j;
                j = 0;
            }
            else
                j++;
        }
        if( j == M)
            return i - M;
        return N;
    }
}
