/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-15
 * Time: 下午1:25
 * To change this template use File | Settings | File Templates.
 */
public class MySuffixArray {
    private final String[] suffixes;
    private final int N;

    public MySuffixArray(String s)
    {
        N = s.length();
        suffixes = new String[N];
        for(int i = 0; i < N; ++i)
        {
            suffixes[i] = s.substring(i);
        }
        Quick3string.sort(suffixes);
    }

    public int length(){ return N; }
    public String select(int i) { return suffixes[i]; }
    public int index(int i) { return N - suffixes[i].length(); }

    private static int lcp(String s, String t)
    {
        int N = Math.min(s.length(), t.length());
        for(int i = 0; i < N; ++i)
            if(s.charAt(i) != t.charAt(i))
                return i;
        return N;
    }
    public int lcp(int i)
    {
        return lcp(suffixes[i], suffixes[i - 1]);
    }

    public int rank(String s)
    {
        int lo = 0, hi = N - 1;
        while (lo <=hi)
        {
            int mid = (lo + hi ) / 2;
            int cmp = s.compareTo(suffixes[mid]);
            if(cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}
