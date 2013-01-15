import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.awt.event.KeyListener;
import java.awt.print.Pageable;

/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-14
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */
public class BTreeSET<Key extends Comparable<Key>> {

    private Page<Key> root = new Page(true);
    public BTreeSET(Key sentinel)
    {
        root.put(sentinel);
    }
    public boolean contains(Key key)
    {
        return contains(root, key);
    }
    private boolean contains(Page h, Key key)
    {
        if(h.isExternal()) return h.contains(key);
        else
            return contains(h.next(key), key);
    }
    public void add(Key key)
    {
        add(root, key);
        if(root.isFull())
        {
            Page<Key> lefthalf = root;
            Page<Key> righthalf = root.split();

            root = new Page(false);
            root.put(lefthalf);
            root.put(righthalf);
        }
    }

    public void add(Page<Key> h, Key key)
    {
        if(h.isExternal()) {h.put(key); return; }

        Page<Key> next = h.next(key);
        add(next, key);
        if(next.isFull())
            h.put(next.split());
        next.close();
    }

    public void print()
    {
        print(root, "");
    }
    private void print(Page<Key> p, String pre)
    {
        StdOut.print(pre);
        for(int i = 0; i < p.num; ++i)
            StdOut.print(p.keys[i] + " ");
        StdOut.println();
        if(p.isExternal())
            return;
        for(int i = 0; i < p.num; ++i)
            print(p.pages[i], pre + "    ");
    }
}

class Page<Key extends Comparable<Key>>
{
    private final int M = 6;
    public int num;
    public Key[] keys;
    public Page[] pages;
    private boolean isExternal;
    public Page(boolean bottom)
    {
        isExternal = bottom;
        keys =(Key[]) new Comparable[M];
        pages = new Page[M];
        num = 0;
    }
    public void close()
    {
        //
    }
    public void put(Key key)
    {
        if(contains(key))
            return;
        keys[num++] = key;
        for(int i = num - 1; i >= 1; --i)
            if(less(keys[i], keys[i  - 1]))
                exch(keys, i, i - 1);
    }
    private boolean less(Key i, Key j)
    {
        return i.compareTo(j) < 0;
    }
    private void exch(Object[] a, int i, int j)
    {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public void put(Page p)
    {
        Key key =(Key) p.keys[0];
        keys[num] = key;
        pages[num++] = p;
        int i;
        for(i = num - 1; i >= 1; --i)
            if(less(keys[i], keys[i  - 1]))
            {
                exch(keys, i, i - 1);
                exch(pages, i, i - 1);
            }
    }
    public boolean isExternal()
    {
        return isExternal;
    }
    public boolean contains(Key key)
    {
        for(int i = 0; i < num; ++i)
            if(keys[i].compareTo(key) == 0)
                return true;
        return false;
    }
    public Page next(Key key)
    {
        int i;
        for(i = 0; i < num; ++i)
        {
            if(less(key, keys[i]))
                break;
        }
        return pages[i - 1];
    }
    public boolean isFull()
    {
        return num == M;
    }
    public Page split()
    {
        Page<Key> p = new Page(isExternal);
        for(int i = M / 2; i < M; ++i)
        {
            p.pages[i - (M / 2)] = pages[i];
            p.keys[i - (M / 2)] = keys[i];
            num = M / 2;
            p.num = M / 2;
        }
        return p;
    }
    public Iterable<Key> keys()
    {
        Bag<Key> bag = new Bag<Key>();
        for(int i = 0; i < num; ++i)
        {
            bag.add(keys[i]);
        }
        return bag;
    }
}

