/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午2:46
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_41 {
    public static void main(String[] args)
    {
        Queue<Integer>  queue1 = new Queue<Integer>();
        for(int i = 0; i < 10; ++i)
            queue1.enqueue(i);
        queue1.print();
        Queue<Integer> queue2 = new Queue<Integer>(queue1);
        queue2.print();
        queue1.dequeue();
        queue1.print();
        queue2.print();
    }
}
