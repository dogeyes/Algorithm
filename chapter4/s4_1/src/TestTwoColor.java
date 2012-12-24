/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-24
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
public class TestTwoColor {
    public static void main(String[] args)
    {
        MyGraph G = new MyGraph(new In(args[0]));
        MyTwoColor twoColor = new MyTwoColor(G);
        StdOut.println(twoColor.isTwoColorable());
    }
}
