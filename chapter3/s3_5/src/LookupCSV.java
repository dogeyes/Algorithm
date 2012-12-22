import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-22
 * Time: 下午3:36
 * To change this template use File | Settings | File Templates.
 */
public class LookupCSV {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valueField = Integer.parseInt(args[2]);
        HashMap<String, String> st = new HashMap<String, String>();
        while (!in.isEmpty())
        {
            String[] fields = in.readLine().split(",");
            st.put(fields[keyField], fields[valueField]);
        }

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            StdOut.println(st.get(s));
        }

    }
}
