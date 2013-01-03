import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午2:30
 * To change this template use File | Settings | File Templates.
 */
public class QueueSort {
    private static int R;
    public static void sort(String[] a)
    {
        R = 256;
        int N = a.length;
        Queue<String> queue = new Queue<String>();
        for(int i = 0; i < N; ++i)
            queue.enqueue(a[i]);
        queue = sort(queue, 0);
        int i = 0;
        while (queue != null && !queue.isEmpty())
            a[i++] = queue.dequeue();
    }
    private static Queue<String> sort(Queue<String> queue, int d)
    {
        if(queue == null || queue.size() <= 1)
            return queue;
        Queue<String>[] queues = new Queue[R + 1];
        while (!queue.isEmpty())
        {
            String s = queue.dequeue();
            int v = charAt(s, d);
            if(queues[v + 1] == null)
                queues[v + 1] = new Queue<String>();
            queues[v + 1].enqueue(s);
        }
        Queue<String> result = new Queue<String>();

        while (queues[0] != null && !queues[0].isEmpty())
            result.enqueue(queues[0].dequeue());
        for(int i = 1; i < R + 1; ++i)
        {
            queue = sort(queues[i], d + 1);
            while (queue !=null && !queue.isEmpty())
                result.enqueue(queue.dequeue());
        }
        return result;
    }
    private static int charAt(String a, int d)
    {
        if(d < a.length())
            return a.charAt(d);
        return -1;
    }
    public static void insertionSort(String[] a, int lo, int hi, int w)
    {
        for(int i = lo;  i <= hi; ++i)
        {
            for(int j = i; j > lo && a[j].substring(w).compareTo(a[j - 1].substring(w)) < 0; j--)
                exch(a, j, j - 1);
        }
    }
    private static void exch(String[] a, int i, int j)
    {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args)
    {
        In in = new In("shells.txt");
        int N = 14;
        String[] a = new String[N];
        for(int i = 0;i < N; ++i)
        {
            a[i] = in.readString();
        }

        insertionSort(a, 0, N - 1, 0);
        StdOut.println(Arrays.toString(a));

        StdRandom.shuffle(a);
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
