/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午9:08
 * To change this template use File | Settings | File Templates.
 */
public class TestSearch {
    public static void main(String[] args)
    {
        MyGraph G = new MyGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        MyDepthFirstSearch search = new MyDepthFirstSearch(G, s);

        for(int v = 0; v < G.V(); ++v)
        {
            if(search.marked(v))
                StdOut.print(v + " ");
        }
        StdOut.println();
        if(search.count() != G.V())
            StdOut.print("NOT");
        StdOut.println(" connected");
    }
}
