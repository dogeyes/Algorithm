import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class Concordance {
    public static void main(String[] args)
    {
        HashMap<String, Queue<Integer>>  map = new HashMap<String, Queue<Integer>>();
        String s = StdIn.readString();
        int count = 0;
        while (!s.equals("!"))
        {
            if(!map.containsKey(s))
                map.put(s, new Queue<Integer>());
            map.get(s).enqueue(count);
            count ++;
            s = StdIn.readString();
        }

        for(String ss : map.keySet())
        {
            StdOut.println(ss + " " + map.get(ss));
        }
    }
}
