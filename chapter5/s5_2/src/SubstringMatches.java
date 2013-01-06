/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-6
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
public class SubstringMatches {
    public static void main(String[] args)
    {
        MytrieST<Queue<String>> st = new MytrieST<Queue<String>>();
        In in = new In("shellsST.txt");
        while (!in.isEmpty())
        {
            String s = in.readString();
            StdOut.print(s + " ");
            for(int i =0 ; i < s.length(); ++i)
            {
                String sub = s.substring(i, s.length());
                if(st.get(sub) == null)
                    st.put(sub, new Queue<String>());
                st.get(sub).enqueue(s);
            }
        }
        StdOut.println();

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            Queue<String> q = new Queue<String>();
            for(String key : st.keysWithPrefix(s))
            {
                Iterable<String> matches = st.get(key);
                if(matches != null)
                    for(String ss: matches)
                        q.enqueue(ss);
            }
            StdOut.println(q);
        }
    }
}
