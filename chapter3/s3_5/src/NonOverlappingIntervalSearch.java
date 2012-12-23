import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午6:49
 * To change this template use File | Settings | File Templates.
 */
public class NonOverlappingIntervalSearch {
    public static void main(String[] args)
    {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int start = StdIn.readInt();
        int end = StdIn.readInt();
        while (start >= 0 && end >= 0)
        {
            map.put(start, end);
            start = StdIn.readInt();
            end = StdIn.readInt();
        }
        int time = StdIn.readInt();
        while (time >= 0)
        {
            Integer s = map.floorKey(time);
            Integer e = map.get(s);
            if(s != null && e >= time)
                StdOut.println(s + " " + e);
            else
                StdOut.println("no");

            time = StdIn.readInt();
        }
    }
}
