/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午8:56
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_25 {
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();
        String now = StdIn.readString();
        while (!now.equals("!"))
        {
            queue.enqueue(now);
            now = StdIn.readString();
        }
        queue.print();
        queue.insertAfter("g", "kps");
        queue.print();
    }
}
