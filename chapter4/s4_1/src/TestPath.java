/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
public class TestPath {
    public static void main(String[] args)
    {
        MyGraph G = new MyGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        MyBreadFirstPaths paths = new MyBreadFirstPaths(G, s);

        for(int v = 0; v < G.V(); ++v)
        {
            if(paths.hasPathTo(v))
            {
                StdOut.print(paths.distTo(v) + " ");
                for(int w : paths.pathTo(v))
                {
                    if(w == s)
                        StdOut.print(w);
                    else
                        StdOut.print("-" + w);
                }
                StdOut.println();
            }

        }

    }
}
