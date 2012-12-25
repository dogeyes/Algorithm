/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-25
 * Time: 下午11:21
 * To change this template use File | Settings | File Templates.
 */
public class RandomGenerateGraph {
    private MyGraph g;
    public RandomGenerateGraph(int V, int E)
    {
        g = new MyGraph(V);
        for(int i =0 ; i < E; ++i)
        {
            int s = StdRandom.uniform(V);
            int e = StdRandom.uniform(V);
            g.addEdge(s, e);
        }
    }

    public MyGraph graph()
    {
        return g;
    }
    public static void main(String[] args)
    {
        RandomGenerateGraph generateGraph = new RandomGenerateGraph(256, 256);
        EuclideanGraph draw = new EuclideanGraph(generateGraph.graph());
        draw.show();
    }
}
