import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午4:07
 * To change this template use File | Settings | File Templates.
 */
public class FullLookupCSV {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        String sp = args[1];
        String[] fields = in.readLine().split(sp);
        int fieldNum = fields.length;
        HashMap<String,Queue<String[]>>[] maps = new HashMap[fieldNum];
        for(int i = 0; i < fieldNum; ++i)
        {
            maps[i] = new HashMap<String, Queue<String[]>>();
        }
        while (true)
        {
            for(int i = 0; i < fieldNum; ++i)
            {
                if(!maps[i].containsKey(fields[i]))
                    maps[i].put(fields[i], new Queue<String[]>());
                maps[i].get(fields[i]).enqueue(fields);
            }
            if(in.isEmpty())
                break;
            fields = in.readLine().split(sp);
        }
        int keyField = StdIn.readInt();
        int valueField = StdIn.readInt();
        while (keyField != -1 && valueField != -1)
        {
            String key = StdIn.readString();
            Queue<String[]> q = maps[keyField].get(key);
            if(q != null)
            {
                for(String[] ss: q)
                {
                    StdOut.print(ss[valueField] + " ");
                }
                StdOut.println();
            }
            keyField = StdIn.readInt();
            valueField = StdIn.readInt();
        }
    }
}
