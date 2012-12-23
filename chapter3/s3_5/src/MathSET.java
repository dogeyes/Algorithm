import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
public class MathSET<Key> {
    private final Key[] universe;
    private boolean[] set;
    private HashMap<Key, Integer>  map;
    private int N;
    private int maxN;
    public MathSET(Key[] universe)
    {
        this.universe = universe;
        maxN = universe.length;
        set = new boolean[maxN];
        map = new HashMap<Key, Integer>();
        for(int i = 0; i < maxN; ++i)
            map.put(universe[i], i);
    }
    private MathSET(Key[] universe, HashMap<Key, Integer>  map)
    {
        this.universe = universe;
        maxN = universe.length;
        set = new boolean[maxN];
        this.map = map;
    }
    public void add(Key key)
    {
        Integer i = map.get(key);
        if(i != null && set[i] == false)
        {
            N++;
            set[i] = true;
        }
    }
    public MathSET<Key> complement()
    {
        MathSET<Key> result = new MathSET<Key>(universe, map);
        for(int i = 0; i < maxN; ++i)
            result.set[i] = !this.set[i];
        return result;
    }
    public boolean contains(Key key)
    {
        Integer i = map.get(key);
        if(i != null && set[i])
            return true;
        return false;
    }
    public void union(MathSET<Key> a)
    {
        for(Key key : a.map.keySet())
            if(a.contains(key))
                add(key);
    }
    public void intersection(MathSET<Key> a)
    {
        for(Key key: map.keySet())
            if(!a.contains(key))
                delete(key);
    }
    public void delete(Key key)
    {
        Integer i = map.get(key);
        if(i != null && set[i] == true)
        {
            N--;
            set[i] = false;
        }
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Key key : map.keySet())
        {
            if(contains(key))
                sb.append(key + " ");
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        String[] universe = new String[N];
        for(int i = 0; i < N; ++i)
        {
            universe[i] = StdIn.readString();
        }
        MathSET<String> set1 = new MathSET<String>(universe);
        MathSET<String> set2 = new MathSET<String>(universe);

        for(int i = 0; i < N / 2; ++i)
        {
            set1.add(universe[StdRandom.uniform(N)]);
        }

        for(int i = 0; i < N / 2; ++i)
        {
            set2.add(universe[StdRandom.uniform(N)]);
        }
        StdOut.println(set1);
        StdOut.println(set2);
        //set1.union(set2);
        //set1.intersection(set2);
        while(!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            set1.delete(s);
            StdOut.println(set1);
        }

    }
}
