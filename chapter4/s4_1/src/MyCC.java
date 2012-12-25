/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午9:50
 * To change this template use File | Settings | File Templates.
 */
public class MyCC {
    private MyGraph G;
    private int count;
    private int[] id;
    private boolean[] marked;
    public MyCC(MyGraph G)
    {
        this.G = G;
        id = new int[G.V()];
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); ++i)
        {
            if(!marked[i])
            {
                bfs(i);
                count++;
            }
        }
    }
    private void bfs(int v)
    {
        Queue<Integer> queue = new Queue<Integer>();
        marked[v] = true;
        id[v] = count;
        queue.enqueue(v);
        while (!queue.isEmpty())
        {
            v = queue.dequeue();
            for(int w: G.adj(v))
            {
                if(!marked[w])
                {
                    marked[w] = true;
                    id[w] = count;
                    queue.enqueue(w);
                }
            }
        }
    }
    private boolean connected(int v, int w)
    {
        return id(v) == id(w);
    }
    public int count()
    {
        return count;
    }
    public int id(int v)
    {
        return id[v];
    }
}
