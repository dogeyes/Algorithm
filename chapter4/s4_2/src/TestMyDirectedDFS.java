/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class TestMyDirectedDFS {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG.txt"));
        StdOut.println(G);

        Bag<Integer> sources = new Bag<Integer>();
        sources.add(1);
        sources.add(2);
        sources.add(6);
        MyDirectedDFS directedDFS = new MyDirectedDFS(G, sources);
        for(int i = 0; i < G.V(); ++i)
            if(directedDFS.marked(i))
                StdOut.println(i + " ");
    }
}
