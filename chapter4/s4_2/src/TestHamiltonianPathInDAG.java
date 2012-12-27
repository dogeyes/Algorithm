/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
public class TestHamiltonianPathInDAG {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG5.txt"));
        StdOut.println(G);

        HamiltonianPathInDAG hamiltonianPathInDAG = new HamiltonianPathInDAG(G);
        StdOut.println(hamiltonianPathInDAG.hasHamiltonianPath());
    }
}
