/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */
public class TestTopological {
    public static void main(String[] args)
    {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("tinyEWD.txt"));
        MyTopological topological = new MyTopological(G);
        if(topological.hasOrder())
        {
            for(int i : topological.order())
                StdOut.print(i + " ");
        }
        else
            StdOut.println("No topological");
    }
}
