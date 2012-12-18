/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午9:39
 * To change this template use File | Settings | File Templates.
 */
public class MyUF {
    private int[] id;
    private int count;
    public MyUF(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i  < N; ++i)
            id[i] = i;
    }
    public int count()
    {
        return count;
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    public int find(int p)
    {
        return id[p];
    }
    public void union(int p, int q)
    {

    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MyUF uf = new MyUF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
