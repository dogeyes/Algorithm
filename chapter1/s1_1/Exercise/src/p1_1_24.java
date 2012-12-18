/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 下午12:34
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_24 {
    public static int gcd(int a, int b)
    {
        System.out.println(a + " " + b);
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args)
    {
        gcd(1111111, 1234567);

    }
}
