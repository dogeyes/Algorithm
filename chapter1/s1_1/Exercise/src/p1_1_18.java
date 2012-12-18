/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_18 {
    public static int mystery(int a, int b)
    {
        if(b == 0) return 0;
        if(b % 2 == 0) return mystery(a + a, b / 2);
        else return mystery(a + a, b / 2) + a;
    }
    public static void main(String[] args)
    {
        StdOut.println(mystery(2, 25));
        StdOut.println(mystery(3, 11));

    }
}
