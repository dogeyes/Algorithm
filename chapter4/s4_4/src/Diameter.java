/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午1:09
 * To change this template use File | Settings | File Templates.
 */
public class Diameter {
    public static void main(String[] args)
    {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("tinyEWD.txt"));
        MyDijkstraSP[] sps = new MyDijkstraSP[G.V()];
        double max = 0;
        for(int i = 0; i < G.V(); ++i)
        {
            sps[i] = new MyDijkstraSP(G, i);
            for(int w = 0; w < G.V(); ++ w)
                if(sps[i].distTo(w) > max)
                    max = sps[i].distTo(w);
        }
        StdOut.println(max);
    }
}
