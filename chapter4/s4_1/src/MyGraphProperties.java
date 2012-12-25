/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-25
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
public class MyGraphProperties {
    private MyGraph G;
    private int diameter;
    private int radius = Integer.MAX_VALUE;
    private int center;
    private int[] eccentricities;
    private int girth = Integer.MAX_VALUE;
    private boolean marked[];
    private int[] disTo;
    private int[] edgeTo;
    public MyGraphProperties(MyGraph g)
    {
        G = g;
        eccentricities = new int[g.V()];
        marked = new boolean[g.V()];
        disTo = new int[g.V()];
        edgeTo = new int[g.V()];

        for(int i = 0; i < G.V(); ++i)
        {
            MyBreadFirstPaths paths = new MyBreadFirstPaths(G, i);
            eccentricities[i] = paths.maxDist();
            if(eccentricities[i] > diameter)
                diameter = eccentricities[i];
            if(eccentricities[i] < radius)
            {
                radius = eccentricities[i];
                center = i;
            }
            for(int j = 0; j < G.V(); ++j)
            {
                marked[j] = false;
                edgeTo[j] = 0;
                disTo[j] = 0;
            }
            disTo[i] = 0;
            bfs(i);
        }
    }
    private void bfs(int s)
    {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(s);
        marked[s] = true;
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();
            for(int w: G.adj(v))
            {
                if(!marked[w])
                {
                    edgeTo[w] = v;
                    disTo[w] = disTo[v] + 1;
                    marked[w] = true;
                    queue.enqueue(w);
                }
                else
                    if(w != edgeTo[v] && disTo[v] + disTo[w] + 1 < girth)
                        girth = disTo[v] + disTo[w] + 1;
            }
        }
    }
    public int eccentricity(int v)
    {
        return eccentricities[v];
    }
    public int radius()
    {
        return radius;
    }
    public int center()
    {
        return center;
    }
    public int diameter()
    {
        return diameter;
    }
    public int girth()
    {
        return girth;
    }
}

