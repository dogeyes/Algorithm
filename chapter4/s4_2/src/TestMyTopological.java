/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class TestMyTopological {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG1.txt"));
        StdOut.println(G);

        MyTopological topological = new MyTopological(G);
        if(topological.isDAG())
        {
            for(int w : topological.order())
            {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }
        else
            StdOut.println("not DAG");
    }
}
