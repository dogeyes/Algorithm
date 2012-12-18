import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 上午10:07
 * To change this template use File | Settings | File Templates.
 */
public class p2_5_4 {
    public static String[] dedup(String[] a)
    {
        Arrays.sort(a);
        int j = 0;
        for(int i = 1; i < a.length; ++i)
        {
            if(!a[i].equals(a[j]))
                a[++j] = a[i];
        }
        String[] b = new String[j + 1];
        for(int i = 0; i < j + 1; ++i)
        {
            b[i] = a[i];
        }
        return b;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        String[] ss = new String[N];
        for(int i = 0; i < N; ++i)
            ss[i] = StdIn.readString();
        ss = dedup(ss);
        StdOut.println(Arrays.toString(ss));
    }
}
