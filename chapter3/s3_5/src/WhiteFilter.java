import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-22
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
public class WhiteFilter {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        HashSet<String> whiteList = new HashSet<String>();
        while(!in.isEmpty())
        {
            String s = in.readString();
            StdOut.println(s);
            whiteList.add(s);
        }

        while(!StdIn.isEmpty()){
           String s = StdIn.readString();
           if(whiteList.contains(s))
               StdOut.println(s);
        }
    }
}
