import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午10:00
 * To change this template use File | Settings | File Templates.
 */
public class QuickFindUF {
    private VisualAccumulator accumulator;
    private int[] id;
    private int count;
    public QuickFindUF(int N)
    {
        accumulator = new VisualAccumulator(10 * N, N * 2);
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
        accumulator.addDateValue(1);
        return id[p];
    }
    public void union(int p, int q)
    {
        int idP = find(p);
        int idQ = find(q);
        if(idP == idQ)
            return;
        for(int i = 0; i < id.length; ++i)
            if(id[i] == idQ)
                id[i] = idP;
        count--;
        accumulator.addDateValue(id.length);
    }
    public void print()
    {
        StdOut.println(Arrays.toString(id));
    }
    public static void main(String[] args)
    {
        In in = new In("mediumUF.txt");
        int N = in.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (!in.isEmpty())
        {
            int p = in.readInt();
            int q = in.readInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p, q);

        }
        uf.print();
        StdOut.println(uf.count() + " components");
    }
}
