import java.util.Arrays;

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
        MySymbolGraph symbolGraph = new MySymbolGraph("movies.txt", "/");
        MyCC cc = new MyCC(symbolGraph.G());

        StdOut.println(cc.count());
        String name = "Bacon, Kevin";
        if(!symbolGraph.contains(name))
            return;
        for(int w: symbolGraph.G().adj(symbolGraph.index(name)))
            StdOut.println(symbolGraph.name(w));

        int[] comNum = new int[cc.count()];
        for(int v = 0; v <  symbolGraph.G().V(); ++v)
        {
            comNum[cc.id(v)] ++;
        }
        StdOut.println(Arrays.toString(comNum));
        StdOut.println(cc.id(symbolGraph.index(name)));
    }
}
