import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public class InvertedConcordance {
    public static void main(String[] args)
    {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        int i = StdIn.readInt();
        while (i != 0)
        {
            String s = StdIn.readString();

            map.put(i, s);

            i = StdIn.readInt();
        }

        for(Integer ss : map.keySet())
        {
            StdOut.println(ss + " " + map.get(ss));
        }
    }
}
