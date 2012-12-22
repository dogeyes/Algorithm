import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-22
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public class MyHashSET<Key> {
    private SeparateChainingHashST<Key, Object> st;
    private Object object;
    public MyHashSET()
    {
        st = new SeparateChainingHashST<Key, Object>();
        object = new Object();
    }
    public int size()
    {
        return st.size();
    }
    public void add(Key key)
    {
        st.put(key, object);
    }
    public void delete(Key key)
    {
        st.delete(key);
    }
    public boolean contains(Key key)
    {
        return st.contains(key);
    }
    public boolean isEmpty()
    {
        return st.isEmpty();
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Key key : st.keys())
        {
            sb.append(key + " ");
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
        {
            a[i] = i;
        }
        StdRandom.shuffle(a);

        StdOut.println(Arrays.toString(a));
        MyHashSET<Integer> set = new MyHashSET<Integer>();
        for(int i = 0; i < N; ++i)
        {
            set.add(a[i]);
        }
        StdOut.println(set.toString());
    }
}
