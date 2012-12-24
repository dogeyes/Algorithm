import java.awt.font.GlyphJustificationInfo;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午9:35
 * To change this template use File | Settings | File Templates.
 */
public class MyBreadFirstPaths {
    private final int s;
    private MyGraph G;
    private int edgeTo[];
    private boolean marked[];
    public MyBreadFirstPaths(MyGraph G, int s)
    {
        this.s = s;
        this.G = G;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        bfs(s);
    }
    private void bfs(int s)
    {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(s);
        marked[s] = true;
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();
            for(int w : G.adj(v))
            {
                if(!marked[w])
                {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(;v != s; v = edgeTo[v])
            stack.push(v);
        stack.push(s);
        return stack;
    }
}
