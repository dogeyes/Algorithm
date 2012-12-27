/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午6:58
 * To change this template use File | Settings | File Templates.
 */
public class QueueBasedTopologicalSort {
    private MyDigraph G;
    private boolean[] marked;
    private Queue<Integer> sources;
    private Queue<Integer> sort;
    private int[] indegrees;
    private boolean hasTopologicalSort;
    public QueueBasedTopologicalSort(MyDigraph G)
    {
        this.G = G;
        indegrees = new int[G.V()];
        marked = new boolean[G.V()];
        sources = new Queue<Integer>();
        sort = new Queue<Integer>();
        hasTopologicalSort = true;
        for(int i = 0; i < G.V(); ++i)
        {
            for(int w: G.adj(i))
                indegrees[w]++;
        }
        for(int i = 0;i < G.V();++i)
            if(indegrees[i] == 0)
                sources.enqueue(i);

        while (!sources.isEmpty())
        {
            if(!hasTopologicalSort)
                break;
            int v = sources.dequeue();
            sort.enqueue(v);
            for(int w: G.adj(v))
            {
                indegrees[w]--;
                if(indegrees[w] == 0)
                    sources.enqueue(w);
                else if(indegrees[w] < 0)
                {
                    hasTopologicalSort = false;
                    break;
                }
            }
        }
    }
    public boolean hasTopologicalSort()
    {
        return hasTopologicalSort;
    }
    public Iterable<Integer> order()
    {
        return sort;
    }
}
