/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public class CyclicRotationCheck {
    public static void main(String[] args)
    {
        String a = StdIn.readString();
        String b = StdIn.readString();
        MyKMPSubStringSearch kmp = new MyKMPSubStringSearch(a);
        int k = kmp.search(b + b);
        StdOut.println(k);
    }
}
