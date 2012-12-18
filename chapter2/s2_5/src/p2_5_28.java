import java.io.File;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-14
 * Time: 下午1:17
 * To change this template use File | Settings | File Templates.
 */
public class p2_5_28 {
    public static void main(String[] args)
    {
        File file = new File(args[0]);
        if(file.isDirectory())
        {
            String[] f = file.list();
            Arrays.sort(f);
            StdOut.println(Arrays.toString(f));
        }
    }
}
