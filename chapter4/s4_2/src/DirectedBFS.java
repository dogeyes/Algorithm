/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 */
public class DirectedBFS {
    private MyDigraph G;
    private boolean[] marked;
    private int[] lengths;
    private int v;
    public DirectedBFS(MyDigraph G, int v)
    {
        this.G = G;
        this.v = v;
        marked = new boolean[G.V()];
        lengths = new int[G.V()];
        for(int i =0; i < G.V(); ++i)
        {
            lengths[i] = G.V();
        }
        lengths[v] = 0;
        bfs(v);
    }
    private void bfs(int s)
    {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();
            for(int w: G.adj(v))
            {
                if(!marked[w])
                {
                    lengths[w] = lengths[v] + 1;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }
    public int dis(int w)
    {
        return lengths[w];
    }
}
