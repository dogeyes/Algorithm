/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午9:49
 * To change this template use File | Settings | File Templates.
 */
public class Algs4Test4 {
    public static void main(String[] args)
    {
        Out out = new Out("out.txt");
        out.println("Test output");
        In in = new In("in.txt");
        while (!in.isEmpty())
        {
            StdOut.println(in.readLine());
        }
    }
}
