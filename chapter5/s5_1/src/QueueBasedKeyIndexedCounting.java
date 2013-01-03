import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */
public class QueueBasedKeyIndexedCounting {
    public static void sort(int[] a, int R)
    {
        int N = a.length;
        Queue<Integer>[] count = new Queue[R];
        for(int i = 0; i < N; ++i)
        {
            if(count[a[i]] == null)
                count[a[i]] = new Queue<Integer>();
            count[a[i]].enqueue(a[i]);
        }
        int j = 0;
        for(int i = 0; i < R; ++i)
        {
            while (count[i] != null && !count[i].isEmpty())
                a[j++] = count[i].dequeue();
        }
    }

    public static void main(String[] args)
    {
        In in = new In("num.txt");
        int n = in.readInt();
        int[] a = new int[n];
        int maxNum = 0;
        for(int i = 0; i < n; ++i)
        {
            a[i] = in.readInt();
            if(a[i] > maxNum)
                maxNum = a[i];
        }
        maxNum++;
        sort(a, maxNum);
        StdOut.println(Arrays.toString(a));
    }
}
