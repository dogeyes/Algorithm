/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午10:32
 * To change this template use File | Settings | File Templates.
 */
public class TestSymbolGraph {
    public static void main(String[] args)
    {
        MySymbolGraph symbolGraph = new MySymbolGraph("routes.txt", " ");
        for(int v = 0; v <  symbolGraph.G().V(); ++v)
        {
            StdOut.println(symbolGraph.name(v) + ": ");
            for(int w: symbolGraph.G().adj(v))
                StdOut.println("    " + symbolGraph.name(w));
        }
    }
}
