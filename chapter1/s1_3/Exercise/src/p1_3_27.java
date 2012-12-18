/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午9:13
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_27 {
    public static void main(String[] args)
    {
        Queue<Integer> queue = new Queue<Integer>();
        Integer now = StdIn.readInt();
        while (!now.equals(0))
        {
            queue.enqueue(now);
            now = StdIn.readInt();
        }
        StdOut.println(queue.recursiveMax());
    }
}
