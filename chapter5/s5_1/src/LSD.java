import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午1:06
 * To change this template use File | Settings | File Templates.
 */
public class LSD {
    public static void sort(String[] a, int W)
    {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for(int i = W - 1; i >= 0; i--)
        {
            int[] count = new int[R + 1];
            int[] index = new int[R];
            for(int j = 0; j < N; ++j)
                count[charAt(a[j], i) + 1]++;
            for(int j = 1; j < R; ++j)
                index[j] = index[j - 1] + count[j];
            for(int j = 0; j < N; ++j)
                aux[index[charAt(a[j], i)] ++] = a[j];
            for(int j = 0; j < N; ++j)
                a[j] = aux[j];
        }
        StdOut.println(Arrays.toString(a));
    }
    private static int charAt(String a, int w)
    {
        return a.charAt(w);
    }
    public static void main(String[] args)
    {
        In in = new In("words3.txt");
        int N = 35;
        int W = 3;
        String[] a = new String[N];
        for(int i = 0; i < N; ++i)
            a[i] = in.readString();
        sort(a, W);
    }
}
