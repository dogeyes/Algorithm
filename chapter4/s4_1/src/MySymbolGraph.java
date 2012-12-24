import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class MySymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private MyGraph G;
    public MySymbolGraph(String filename, String delim)
    {
        In in = new In(filename);
        st = new ST<String, Integer>();
        while (!in.isEmpty())
        {
            String[] a = in.readLine().split(delim);
            for(int i = 0; i < a.length; ++i)
                if(!st.contains(a[i]))
                    st.put(a[i], st.size());
        }
        keys = new String[st.size()];
        for(String key: st.keys())
            keys[st.get(key)] = key;

        G = new MyGraph(st.size());
        in = new In(filename);
        while (!in.isEmpty())
        {
            String[] a = in.readLine().split(delim);
            int v = index(a[0]);
            for(int i = 1; i < a.length; ++i)
                G.addEdge(v, index(a[i]));
        }

    }
    public boolean contains(String key)
    {
        return st.contains(key);
    }
    public int index(String key)
    {
        return st.get(key);
    }
    public String name(int v)
    {
        return keys[v];
    }
    public MyGraph G()
    {
        return G;
    }

}
