/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午7:10
 * To change this template use File | Settings | File Templates.
 */
public class MyKMPSubStringSearch {
    private static int R = 256;
    private int[][] dfa;
    private String pat;
    private int M;
    public MyKMPSubStringSearch(String pat)
    {
        this.pat = pat;
        M = pat.length();
        dfa = new int[R][M];

        dfa[pat.charAt(0)][0] = 1;

        int X = 0;
        for(int i = 1; i < M; ++i)
        {
            for(int c = 0; c < R; ++c)
                dfa[c][i] = dfa[c][X];
            dfa[pat.charAt(i)][i] = i + 1;
            X = dfa[pat.charAt(i)][X];
        }

        /*for(int j = 0; j < M; ++j)
        {
            for(char c = 0; c < R; ++c)
            {
                if(c == 'A' || c == 'B' || c == 'C' || c== 'D' || c == 'R')
                    StdOut.printf("%4d", dfa[c][j]);
            }
            StdOut.println();
        } */
    }

    public int search(String txt)
    {
        int i, N = txt.length();
        int j;
        for(i = 0, j = 0; i < N && j < M; ++i)
        {
            j = dfa[txt.charAt(i)][j];
        }
        if(j == M)
            return i - j;
        else
            return N;
    }
    public int count(String txt)
    {
        int count = 0;
        int j = 0;
        while (true)
        {
            j = search(txt);
            if(j < txt.length())
                count++;
            else
                break;
            txt = txt.substring(j + 1);
        }
        return count;
    }

    public Iterable<Integer> searchAll(String txt)
    {
        Queue<Integer> q = new Queue<Integer>();
        int j = 0;
        int pre = 0;
        while (true)
        {
            j = search(txt);
            if(j < txt.length())
                q.enqueue(j + pre);
            else
                break;
            pre = pre + j + 1;
            txt = txt.substring(j + 1);
        }
        return q;
    }
}
