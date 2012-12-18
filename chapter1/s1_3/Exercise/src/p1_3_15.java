/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_15 {
    public static void main(String[] args)
    {
        int k = StdIn.readInt();
        CircularQueue<String> queue = new CircularQueue<String>();
        String now = StdIn.readString();
        while (!now.equals("!"))
        {
            queue.enqueue(now);
            if(k < queue.size())
                queue.dequeue();
            now = StdIn.readString();
        }
        while (!queue.isEmpty())
        {
            StdOut.println(queue.dequeue());
        }
    }
}
