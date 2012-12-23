import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public class p3_5_13 {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valueField = Integer.parseInt(args[2]);
        TreeMap<String, String> st = new TreeMap<String, String>();
        while (!in.isEmpty())
        {
            String[] fields = in.readLine().split(",");
            st.put(fields[keyField], fields[valueField]);
        }

        while (!StdIn.isEmpty())
        {
            String start = StdIn.readString();
            String end = StdIn.readString();
            for(String key : st.subMap(start, true, end, true).keySet())
                StdOut.println(key + ":" +  st.get(key) + " ");
        }

    }
}
