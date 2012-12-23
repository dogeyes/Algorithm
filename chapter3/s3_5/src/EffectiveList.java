import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午7:28
 * To change this template use File | Settings | File Templates.
 */
public class EffectiveList<Item extends Comparable<Item>> implements Iterable<Item> {
    private RedBlackBST<Double, Item> order;
    private RedBlackBST<Item, Double> items;

    public EffectiveList()
    {
        order = new RedBlackBST<Double, Item>();
        items = new RedBlackBST<Item, Double>();
    }
    public void addFront(Item item)
    {
        if(isEmpty())
        {
            items.put(item, 0.0);
            order.put(0.0, item);
            return;
        }
        Double k = order.min() - 1;
        items.put(item, k);
        order.put(k, item);
    }
    public void addBack(Item item)
    {
        if(isEmpty())
        {
            items.put(item, 0.0);
            order.put(0.0, item);
            return;
        }
        Double k = order.max() + 1;
        items.put(item, k);
        order.put(k, item);
    }
    public Item deleteFront()
    {
        Double k = order.min();
        Item item = order.get(k);
        order.delete(k);
        items.delete(item);
        return item;
    }
    public Item deleteBack()
    {
        Double k = order.max();
        Item item = order.get(k);
        order.delete(k);
        items.delete(item);
        return item;
    }
    public void delete(Item item)
    {
        Double k = items.get(item);
        if(k == null)
            return;
        order.delete(k);
        items.delete(item);
    }
    public void add(int i, Item item)
    {
        Double k = (order.select(i) + order.select(i - 1)) / 2;
        items.put(item, k);
        order.put(k, item);
    }
    public Item delete(int i)
    {
        Double k = (order.select(i));
        Item item = order.get(k);
        items.delete(item);
        order.delete(k);
        return item;
    }
    public boolean contains(Item item)
    {
        return items.contains(item);
    }
    public boolean isEmpty()
    {
        return items.isEmpty();
    }
    public int size()
    {
        return items.size();
    }
    public Iterator<Item> iterator()
    {
        return new Iterator<Item>() {
            int rank = 0;
            public boolean hasNext() {
                if(rank != size())
                    return true;
                return false;
            }

            @Override
            public Item next() {
                return order.get(order.select(rank++));
            }

            @Override
            public void remove() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
    public static void main(String[] args)
    {
        EffectiveList<Integer> list = new EffectiveList<Integer>();
        int N = StdIn.readInt();
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
        {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        for(int i = 0; i < N; ++i)
        {
            list.addBack(a[i]);
        }

        list.add(1, 100);
        list.add(1, 200);
        list.add(1, 300);

        list.delete(9);
        list.delete(new Integer(2));
        while (!list.isEmpty())
            StdOut.print(list.deleteFront() + " ");
    }
}
