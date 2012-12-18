import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-12
 * Time: 上午9:33
 * To change this template use File | Settings | File Templates.
 */
public class DynamicMedian<Key extends Comparable<Key>> {
    private MaxPQ<Key> maxPQ;
    private MinPQ<Key> minPQ;
    private Key _median;
    public DynamicMedian()
    {
        maxPQ = new MaxPQ<Key>();
        minPQ = new MinPQ<Key>();
    }

    public void insert(Key item)
    {
        if(maxPQ.size() == 0 && minPQ.size() == 0)
        {
            maxPQ.insert(item);
            _median = item;
            return;
        }
        if(item.compareTo(_median) >= 0)
            minPQ.insert(item);
        else
            maxPQ.insert(item);
        if(maxPQ.size() < minPQ.size())
        {
            _median = minPQ.delMin();
            maxPQ.insert(_median);
        }else if(maxPQ.size() > minPQ.size() + 1)
        {
            minPQ.insert(maxPQ.delMax());
            _median = maxPQ.max();
        }
    }
    public void delMedian()
    {
        maxPQ.delMax();
        if(maxPQ.size() < minPQ.size())
        {
            _median = minPQ.delMin();
            maxPQ.insert(_median);
        }
        else
            _median = minPQ.min();
    }
    public Key median()
    {
        return _median;
    }
    public static void main(String[] args)
    {
        DynamicMedian<Integer> dynamicMedian = new DynamicMedian<Integer>();
        int N = 3;
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        for(int i = 0; i < N; ++i)
        {
            dynamicMedian.insert(a[i]);
            StdOut.println(dynamicMedian.median());
        }
    }
}
