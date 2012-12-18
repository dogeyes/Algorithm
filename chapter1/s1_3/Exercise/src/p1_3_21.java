/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午8:47
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_21 {
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();
        String now = StdIn.readString();
        while (!now.equals("!"))
        {
            queue.enqueue(now);
            now = StdIn.readString();
        }
        StdOut.println(queue.find("g"));
    }
}
