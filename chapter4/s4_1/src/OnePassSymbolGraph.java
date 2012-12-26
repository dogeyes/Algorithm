/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-25
 * Time: 下午8:44
 * To change this template use File | Settings | File Templates.
 */
public class OnePassSymbolGraph {
    private ST<String, Bag<String>> g;
    public OnePassSymbolGraph(String filename, String delima)
    {
        In in = new In(filename);
        g = new ST<String, Bag<String>>();
        while (!in.isEmpty())
        {
            String[] s = in.readLine().split(delima);
            for(int i = 1; i < s.length; ++i)
            {
                put(s[0], s[i]);
                put(s[i], s[0]);
            }
        }
    }
    private void put(String s1, String s2)
    {
        if(!g.contains(s1))
            g.put(s1, new Bag<String>());
        g.get(s1).add(s2);
    }
    public Iterable<String> Vs()
    {
        return g.keys();
    }
    public Iterable<String> adj(String s)
    {
        return g.get(s);
    }
    public void addEdge(String s1, String s2)
    {
        put(s1, s2);
        put(s2, s1);
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(String v : Vs())
        {
            sb.append(v + " : " + "\n");
            for(String w: adj(v))
                sb.append( "    " + w + "\n");

        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        OnePassSymbolGraph g = new OnePassSymbolGraph("../../algs4-data/routes.txt", " ");
        StdOut.println(g);
    }
}
