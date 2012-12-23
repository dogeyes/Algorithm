import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class p3_5_12 {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valueField = Integer.parseInt(args[2]);
        HashMap<String, Queue<String>> st = new HashMap<String, Queue<String>>();
        while (!in.isEmpty())
        {
            String[] fields = in.readLine().split(",");
            String key = fields[keyField];
            String value = fields[valueField];
            if(!st.containsKey(key))
                st.put(key, new Queue<String>());
            st.get(key).enqueue(value);
        }

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            StdOut.println(st.get(s));
        }

    }
}
