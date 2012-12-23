import com.sun.org.apache.xml.internal.dtm.ref.DTMAxisIterNodeList;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午8:08
 * To change this template use File | Settings | File Templates.
 */
public class RandomAccessST<Key, Value> {
    private HashMap<Key, Value> map;
    private RandomQueue queue;
    public RandomAccessST()
    {
        map = new HashMap<Key, Value>();
        queue = new RandomQueue();
    }
    public void put(Key key, Value value)
    {
        if(!map.containsKey(key))
            queue.enqueue(key);
        map.put(key, value);
    }
    public Key delete()
    {
        Key key = queue.dequeue();
        map.remove(key);
        return key;
    }
    public Key random()
    {
        Key key = queue.dequeue();
        queue.enqueue(key);
        return key;
    }
    public Value get(Key key)
    {
        return map.get(key);
    }
    private class RandomQueue
    {
        int maxN;
        int N;
        Key[] queue;
        public RandomQueue()
        {
            maxN = 16;
            queue = (Key[]) new Object[maxN];
        }
        public void enqueue(Key key)
        {
            int i;
            if(N == 0)
                i = 0;
            else
                i = StdRandom.uniform(N);
            queue[N++] = queue[i];
            queue[i] = key;
            if(N == maxN)
                resize(maxN * 2);
        }
        public Key dequeue()
        {
            if(N == maxN / 2)
                resize(maxN / 2);
            return queue[--N];
        }
        private void resize(int size)
        {
            Key[] a = (Key[]) new Object[size];
            for(int i = 0; i < N; ++i)
            {
                a[i] = queue[i];
            }
            maxN = size;
            queue = a;
        }
    }
    public boolean isEmpty()
    {
        return map.isEmpty();
    }
    public int size()
    {
        return map.size();
    }
    public static void main(String[] args)
    {
        RandomAccessST<Integer, Integer> st = new RandomAccessST<Integer, Integer>();
        int N = StdIn.readInt();
        for(int i = 0; i < N; ++i)
            st.put(i, i);
        while (!st.isEmpty())
        {
            StdOut.print(st.delete() + " ");

        }
        StdOut.println();
    }
}
