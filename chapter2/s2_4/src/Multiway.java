/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 上午10:14
 * To change this template use File | Settings | File Templates.
 */
public class Multiway {
    public static void merge(In[] streams)
    {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
        for(int i = 0; i < N; ++i)
        {
            pq.insert(i, streams[i].readString());
        }
        while(!pq.isEmpty())
        {
            StdOut.print(pq.min() + " ");
            int i = pq.delMin();
            if(!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
    }
    public static void main(String[] args)
    {
        int N = args.length;
        In[] streams = new In[N];
        for(int i =0 ; i < N; ++i)
        {
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }
}
