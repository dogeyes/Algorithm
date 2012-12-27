/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午7:40
 * To change this template use File | Settings | File Templates.
 */
public class ArithmetricExpression {
    private int V;
    private int E;
    private boolean[] marked;
    private MyDigraph G;
    private String[] st;
    private MyTopological topological;
    private int result;
    private int[] values;
    public ArithmetricExpression(In in)
    {
        V = in.readInt();
        E = in.readInt();
        st = new String[V];
        marked = new boolean[V];
        for(int i = 0; i < V; ++i)
        {
            String name = in.readString();
            st[i] = name;
        }
        G = new MyDigraph(V);
        for(int i = 0; i < E; ++i)
        {
            int v = in.readInt();
            int w = in.readInt();
            G.addEdge(v, w);
        }
        topological = new MyTopological(G);
        values = new int[V];
        for(int w: topological.order())
        {
            StdOut.println("the first " + w);
            dfs(w);
            result = values[w];
            break;
        }
    }
    private int dfs(int v)
    {
        marked[v] = true;
        int result;
        if(st[v].equals("+")||st[v].equals("-"))
            result = 0;
        else if(st[v].equals("*") || st[v].equals("/"))
            result = 1;
        else
        {
            int a = Integer.parseInt(st[v]);
            values[v] = a;
            return a;
        }
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                if(st[v].equals("+"))
                    result += dfs(w);
                else if(st[v].equals("-"))
                    result -= dfs(w);
                else if(st[v].equals("*"))
                    result *= dfs(w);
                else if(st[v].equals("/"))
                    result /= dfs(w);
            }
            else
            {
                if(st[v].equals("+"))
                    result += values[w];
                else if(st[v].equals("-"))
                    result -= values[w];
                else if(st[v].equals("*"))
                    result *= values[w];
                else if(st[v].equals("/"))
                    result /= values[w];
            }
        }
        values[v] = result;
        return result;
    }
    public int result()
    {
        return result;
    }
    public static void main(String[] args)
    {
        ArithmetricExpression arithmetricExpression = new ArithmetricExpression(new In("Arithmetric.txt"));
        StdOut.println(arithmetricExpression.result);
    }
}

