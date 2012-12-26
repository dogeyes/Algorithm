/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午10:21
 * To change this template use File | Settings | File Templates.
 */
public class TestMyKosarajuSCC {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG.txt"));
        StdOut.println(G);

        MyKosarajuSCC scc = new MyKosarajuSCC(G);
        Bag<Integer>[] bags = new Bag[scc.count()];
        for(int i = 0; i < scc.count(); ++i)
        {
            bags[i] = new Bag<Integer>();
        }
        for(int v = 0; v < G.V(); ++v)
        {
            bags[scc.id(v)].add(v);
        }

        for(int i = 0; i < scc.count(); ++i)
        {
            for(int w : bags[i])
                StdOut.print(w + " ");
            StdOut.println();
        }

    }
}
