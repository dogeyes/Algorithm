import sun.rmi.runtime.NewThreadAction;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午10:37
 * To change this template use File | Settings | File Templates.
 */
public class MyDegreeOfSeparation {
    public static void main(String[] args)
    {
        MySymbolGraph sg = new MySymbolGraph("routes.txt", " ");
        MyGraph G = sg.G();

        String source = StdIn.readLine();
        if(!sg.contains(source))
        {
            StdOut.println(source + " is not in database");
            return;
        }
        MyBreadFirstPaths paths = new MyBreadFirstPaths(G, sg.index(source));
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readLine();
            if(sg.contains(s))
            {
                StdOut.println(s + " :");
                int v = sg.index(s);
                if(paths.hasPathTo(v))
                    for(int w: paths.pathTo(v))
                    {
                        StdOut.println("   " + sg.name(w));
                    }
            }
        }
    }
}
