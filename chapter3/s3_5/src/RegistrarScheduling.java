import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午6:56
 * To change this template use File | Settings | File Templates.
 */
public class RegistrarScheduling {
    public static void main(String[] args)
    {
        HashMap<Integer, SET<String>> map = new HashMap<Integer, SET<String>>();
        int time = StdIn.readInt();
        String name = StdIn.readString();
        while (time > 0)
        {
            if(!map.containsKey(time))
                map.put(time, new SET<String>());
            if(map.get(time).contains(name))
                StdOut.println("Conflict");
            else
                map.get(time).add(name);
            time = StdIn.readInt();
            name = StdIn.readString();
        }
    }
}
