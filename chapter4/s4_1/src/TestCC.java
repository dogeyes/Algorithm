/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 */
public class TestCC {
    public static void main(String[] args)
    {
        MyGraph G = new MyGraph(new In(args[0]));
        MyCC cc = new MyCC(G);
        Bag<Integer>[] components = (Bag<Integer>[])new Bag[cc.count()];
        for(int i = 0; i < cc.count(); ++i)
            components[i] = new Bag<Integer>();
        for(int i = 0; i < G.V(); ++i)
        {
            components[cc.id(i)].add(i);
        }
        for(int i = 0; i < cc.count(); ++i)
        {
            for(int v: components[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
    }
}
