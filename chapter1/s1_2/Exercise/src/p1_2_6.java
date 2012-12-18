/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-20
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class p1_2_6 {
    public static void main(String[] args)
    {
        String sou = StdIn.readString();
        String des = StdIn.readString();
        StdOut.println((des + des).indexOf(sou) != -1);
    }
}
