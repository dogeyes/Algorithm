import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午7:45
 * To change this template use File | Settings | File Templates.
 */
public class KendallTauDistance {
    public static void kendall(int[] p1, int[] p2)
    {
        int N = p1.length;
        int[] index1 = new int[N];
        int[] index2 = new int[N];

        for(int i = 0; i < N; ++i)
        {
            index1[p1[i]] = i;
        }
        for(int i = 0; i < N; ++i)
        {
            index2[i] = index1[p2[i]];
        }
        Integer[] p3 = new Integer[N];
        for(int i = 0; i < N; ++i)
            p3[i] = index2[i];
        StdOut.println(MergeSort.sort(p3));
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        int[] p1 = new int[N];
        int[] p2 = new int[N];
        for(int i = 0; i < N; ++i)
        {
            p1[i] = i;
            p2[i] = i;
        }
        StdRandom.shuffle(p1);
        StdRandom.shuffle(p2);
        StdOut.println(Arrays.toString(p1));
        StdOut.println(Arrays.toString(p2));
        kendall(p1, p2);
    }
}
