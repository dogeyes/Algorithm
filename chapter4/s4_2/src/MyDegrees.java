/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 上午8:57
 * To change this template use File | Settings | File Templates.
 */
public class MyDegrees {
    private int[] indegrees;
    private int[] outdegrees;
    private Queue<Integer> sources;
    private Queue<Integer> sinks;
    private boolean isMap;
    public MyDegrees(MyDigraph G)
    {
        isMap = true;
        indegrees = new int[G.V()];
        outdegrees = new int[G.V()];
        sources = new Queue<Integer>();
        sinks = new Queue<Integer>();
        for(int v = 0; v < G.V(); ++v)
        {
            int count = 0;
            for(int w: G.adj(v))
            {
                outdegrees[v]++;
                indegrees[w]++;
            }
        }
        for(int i = 0; i < G.V(); ++i)
        {
            if(indegrees[i] == 0)
                sources.enqueue(i);
            if(outdegrees[i] == 0)
                sinks.enqueue(i);
            if(outdegrees[i] != 1)
                isMap = false;
        }
    }
    public int indegree(int v)
    {
        return indegrees[v];
    }
    public int outdegree(int v)
    {
        return outdegrees[v];
    }
    public Iterable<Integer> soucrces()
    {
        return sources;
    }
    public Iterable<Integer> sinks()
    {
        return sinks;
    }
    public boolean isMap()
    {
        return isMap;
    }
}
