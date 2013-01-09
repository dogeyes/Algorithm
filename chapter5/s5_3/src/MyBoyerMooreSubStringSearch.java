/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午7:33
 * To change this template use File | Settings | File Templates.
 */
public class MyBoyerMooreSubStringSearch {
    private int[] right;
    private String pat;
    private int M;
    private static int R = 256;
    public MyBoyerMooreSubStringSearch(String pat)
    {
        this.pat = pat;
        M = pat.length();
        right = new int[R];

        for(int i = 0; i < R; ++i)
            right[i] = - 1;
        for(int i = 0; i < M; ++i)
            right[pat.charAt(i)] = i;
    }
    public int search(String txt)
    {
        int i, j, N = txt.length();

        i = 0;
        j = M - 1;
        while(i <= N - M && j >= 0)
        {
            if(txt.charAt(i + j) == pat.charAt(j))
                j--;
            else
            {
                int skip = j - right[txt.charAt(i + j)];
                if(skip < 1)
                    i++;
                else
                    i += skip;
                j = M - 1;
            }
        }
        if(j < 0)
            return i;
        else
            return  N;
    }
}
