import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午2:10
 * To change this template use File | Settings | File Templates.
 */
public class InvertST {
    public static HashMap<String, Bag<String>> invert(HashMap<String, Bag<String>> inMap)
    {
        HashMap<String, Bag<String>>  st = new HashMap<String, Bag<String>>();
        for(String key: inMap.keySet())
        {
            for(String value: inMap.get(key))
            {
                if(!st.containsKey(value))
                    st.put(value, new Bag<String>());
                st.get(value).add(key);
            }
        }
        return st;
    }
    public static void main(String[] args)
    {
        HashMap<String, Bag<String>> st = new HashMap<String, Bag<String>>();
        In in = new In(args[0]);
        String sp = args[1];
        while (!in.isEmpty())
        {
            String[] tokens = in.readLine().split(sp);
            StdOut.println(tokens[0]);
            if(!st.containsKey(tokens[0]))
                st.put(tokens[0], new Bag<String>());
            Bag<String> q = st.get(tokens[0]);
            for(int i = 1; i < tokens.length; ++i)
            {
                q.add(tokens[i]);
            }
        }
        HashMap<String, Bag<String>>  inv = invert(st);
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readLine();
            if(st.containsKey(s))
            {
                for(String item : st.get(s))
                    StdOut.println(item +" ");
                StdOut.println();
            }

            if(inv.containsKey(s))
            {
                for(String item : inv.get(s))
                    StdOut.println(item +" ");
                StdOut.println();
            }
        }
    }
}
