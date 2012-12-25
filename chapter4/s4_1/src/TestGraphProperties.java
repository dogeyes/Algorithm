/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-25
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class TestGraphProperties {
    public static void main(String[] args)
    {
        MyGraph G = new MyGraph(new In(args[0]));
        MyGraphProperties properties = new MyGraphProperties(G);

        StdOut.println(G);
        StdOut.println(properties.center());
        StdOut.println(properties.radius());
        StdOut.println(properties.diameter());
        StdOut.println(properties.girth());
    }
}
