import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-22
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */
public class LookupIndex {
    public static void main(String[] args)
    {
        HashMap<String, Queue<String>> st = new HashMap<String, Queue<String>>();
        HashMap<String, Queue<String>> ts = new HashMap<String, Queue<String>>();
        In in = new In(args[0]);
        String sp = args[1];
        while (!in.isEmpty())
        {
            String[] tokens = in.readLine().split(sp);
            StdOut.println(tokens[0]);
            if(!st.containsKey(tokens[0]))
                st.put(tokens[0], new Queue<String>());
            Queue<String> q = st.get(tokens[0]);
            for(int i = 1; i < tokens.length; ++i)
            {
                q.enqueue(tokens[i]);
                if(!ts.containsKey(tokens[i]))
                    ts.put(tokens[i], new Queue<String>());
                ts.get(tokens[i]).enqueue(tokens[0]);
            }
        }

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readLine();
            if(st.containsKey(s))
            {
                for(String item : st.get(s))
                    StdOut.println(item +" ");
                StdOut.println();
            }
            if(ts.containsKey(s))
            {
                for(String item : ts.get(s))
                    StdOut.println(item +" ");
                StdOut.println();
            }
        }
    }
}
