import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午10:49
 * To change this template use File | Settings | File Templates.
 */
public class WeightedQuickFindUF {
    private int[] id;
    private int[] weights;
    private int count;
    public WeightedQuickFindUF(int N)
    {
        count = N;
        id = new int[N];
        weights = new int[N];
        for(int i = 0; i  < N; ++i)
        {
            id[i] = i;
            weights[i] = 1;
        }
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
        int idP = find(p);
        int idQ = find(q);
        if(idP == idQ)
            return;
        int from, to;
        if(weights[idP] > weights[idQ])
        {
            from = idQ;
            to = idP;
        }
        else
        {
            from = idP;
            to = idQ;
        }

        for(int i = 0; i < id.length; ++i)
            if(id[i] == from)
                id[i] = to;
        weights[to] += weights[from];
        count--;
    }
    public void print()
    {
        StdOut.println(Arrays.toString(id));
        StdOut.println(Arrays.toString(weights));
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        WeightedQuickFindUF uf = new WeightedQuickFindUF(N);
        while (true)
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(p == q)
                break;
            if(uf.connected(p,q))
                continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);

        }
        uf.print();
        StdOut.println(uf.count() + " components");
    }
}
