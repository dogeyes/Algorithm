/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */
public class DirectedEulerianCycle {
    private MyDigraph G;
    private boolean hasDirectedEulerianCycle;
    private Stack<Integer> preStack;
    private Stack<Integer> postStack;

    private SET<Edge> marked;

    private class Edge implements Comparable<Edge>
    {
        int v;
        int w;
        public Edge(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge that)
        {
            if(v != that.v)
                return v - that.v;
            else
                return w - that.w;
        }
    }

    public DirectedEulerianCycle(MyDigraph G)
    {
        this.G = G;
        MyDegrees degrees = new MyDegrees(G);
        hasDirectedEulerianCycle = true;
        for(int i = 0; i < G.V(); ++i)
        {
            if(degrees.indegree(i) != degrees.outdegree(i))
            {
                hasDirectedEulerianCycle = false;
                break;
            }
        }
        preStack = new Stack<Integer>();
        postStack = new Stack<Integer>();
        marked = new SET<Edge>();
    }
    public boolean hasDirectedEulerianCycle()
    {
        return hasDirectedEulerianCycle;
    }
    public Iterable<Integer> eulerianCycle()
    {
        if(hasDirectedEulerianCycle)
        {
            dfs(0);
        }
        Stack<Integer> result = new Stack<Integer>();
        while (!preStack.isEmpty())
            result.push(preStack.pop());
        return result;
    }
    private void dfs(int s)
    {
        preStack.push(s);
        for(int w: G.adj(s))
        {
            if(!marked.contains(new Edge(s, w)))
            {
                while (preStack.peek() != s)
                {
                    postStack.push(preStack.pop());
                }
                marked.add(new Edge(s, w));
                dfs(w);
            }

        }
        while (!postStack.isEmpty())
            preStack.push(postStack.pop());
    }
}
