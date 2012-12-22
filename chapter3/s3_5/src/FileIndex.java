import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-22
 * Time: 下午4:06
 * To change this template use File | Settings | File Templates.
 */
public class FileIndex {
    public static void main(String[] args)
    {
        File[] files = new File[args.length];
        HashMap<String, SET<File>> st = new HashMap<String, SET<File>>();
        for(int i = 0; i < args.length; ++i)
        {
            files[i] = new File(args[i]);
            In in = new In(files[i]);
            while (!in.isEmpty())
            {
                String s = in.readString();
                if(!st.containsKey(s))
                    st.put(s, new SET<File>());
                st.get(s).add(files[i]);
            }
        }

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if(st.containsKey(s))
            {
                for(File file: st.get(s))
                {
                    StdOut.println(file.getName());
                }
            }
        }
    }
}
