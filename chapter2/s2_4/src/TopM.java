/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 上午9:35
 * To change this template use File | Settings | File Templates.
 */
public class TopM {
    public static void main(String[] args)
    {
        int M = StdIn.readInt();
        MyMaxPQ<Integer> pq = new MyMaxPQ<Integer>(M + 1);
        int k = StdIn.readInt();
        while(k != 0)
        {
            pq.insert(k);
            if(pq.size() > M)
                pq.delMax();
            k = StdIn.readInt();
        }

        while(!pq.isEmpty())
            StdOut.println(pq.delMax());
    }
}
