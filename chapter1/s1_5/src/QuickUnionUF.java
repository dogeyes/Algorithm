import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午10:06
 * To change this template use File | Settings | File Templates.
 */
public class QuickUnionUF {
    private int[] id;
    private int count;
    private VisualAccumulator visualAccumulator;
    public QuickUnionUF(int N)
    {
        visualAccumulator = new VisualAccumulator(N * 10, 2* N);
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
        int count = 0;
        int root = p;
        while (root != id[root])
        {
            root = id[root];
            count += 2;
        }
        while (p != id[p])
        {
            int tmp = p;
            p = id[p];
            id[tmp] = root;
            count += 3;
        }
        visualAccumulator.addDateValue(count);
        return root;
    }
    public void union(int p, int q)
    {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId)
            return;
        id[pId] = qId;
        count--;
        visualAccumulator.addDateValue(1);
    }
    public void print()
    {
        StdOut.println(Arrays.toString(id));
    }
    public static void main(String[] args)
    {
        In in = new In("mediumUF.txt");
        int N = in.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
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
