import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午3:39
 * To change this template use File | Settings | File Templates.
 */
public class Frequency {
    private static class Counter<T> implements Comparable<Counter<T>>
    {
        public T item;
        public int count;
        public Counter(T item)
        {
            this.item = item;
            count = 1;
        }
        public void inc()
        {
            count++;
        }
        public int compareTo(Counter<T> that)
        {
            return this.count - that.count;
        }
        public String toString()
        {
            return "[" + item + ": " + count + "] ";
        }
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Counter<String>[] counters = new Counter[N];
        int len = 0;
        for(int i = 0; i < N; ++i)
        {
            String s = StdIn.readString();
            int k = find(counters, len, s);
            if(k >= 0)
                counters[k].inc();
            else
                counters[len ++] = new Counter(s);
        }

        InsertionSort.sort(counters, 0, len - 1);

        StdOut.println(Arrays.toString(counters));
    }
    public static <T> int find(Counter<T>[] counters, int len,  T item)
    {
        for(int i = 0; i < len; ++i)
        {
            if(counters[i].item.equals(item))
                return i;
        }
        return -1;
    }
}
