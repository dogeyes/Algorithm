import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午7:06
 * To change this template use File | Settings | File Templates.
 */
public class ForceStability {
    private static class Wrap
    {
        public Comparable item;
        public int index;
        public Wrap(Comparable item, int index)
        {
            this.item = item;
            this.index = index;
        }
        public static class itemComp implements Comparator<Wrap>
        {
            public int compare(Wrap wrap1, Wrap wrap2)
            {
                return wrap1.item.compareTo(wrap2.item);
            }
        }
        public static class indexComp implements Comparator<Wrap>
        {
            public int compare(Wrap wrap1, Wrap wrap2)
            {
                return wrap1.index - wrap2.index;
            }
        }
        public String toString()
        {
            return item.toString() + ":" + index;
        }
    }
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        Wrap[] wraps = new Wrap[N];
        for(int i = 0; i < N; ++i)
            wraps[i] = new Wrap(a[i], i);
        sort(wraps, 0, N - 1, new Wrap.itemComp()); //对item进行排序
        StdOut.println(Arrays.toString(wraps));
        //接下来对item相同的index进行排序
        int i = 0;
        int j;
        for(j = 0; j < N; ++j)
        {
            if(wraps[j].item.equals(wraps[i].item))
                continue;
            sort(wraps, i, j - 1, new Wrap.indexComp());
            i = j;
        }
        sort(wraps, i, j - 1, new Wrap.indexComp());
        StdOut.println(Arrays.toString(wraps));
    }
    public static void sort(Wrap[] a, int lo, int hi, Comparator comparator)//we use selection sort here
    {
        for(int i = lo ; i <= hi; ++i )
        {
            int min = i;
            for(int j = i + 1; j <= hi; ++j)
                if(comparator.compare(a[j], a[min]) < 0)
                    min = j;
            Wrap tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
    public static void main(String[] agrs)
    {
        int N = StdIn.readInt();
        String[] s = new String[N];
        for(int i = 0; i < N; ++i)
            s[i] = StdIn.readString();
        StdRandom.shuffle(s);
        sort(s);
    }
}
