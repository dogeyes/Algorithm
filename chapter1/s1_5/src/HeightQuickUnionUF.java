import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午11:30
 * To change this template use File | Settings | File Templates.
 */
public class HeightQuickUnionUF {
    private int[] id;
    private int[] heights;
    private int count;
    public HeightQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        heights = new int[N];
        for(int i = 0; i  < N; ++i)
        {
            id[i] = i;
            heights[i] = 1;
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
        int root = p;
        while(root != id[root])
            root = id[root];
        return root;
    }
    public void union(int p, int q)
    {
        int pId = find(p);
        int qId = find(q);
        if(qId == pId)
            return;
        if(heights[pId] < heights[qId])
        {
            id[pId] = qId;
        }
        else if(heights[pId] > heights[qId])
        {
            id[qId] = pId;
        }else
        {
            id[pId] = qId;
            heights[qId]++;
        }
        count--;

    }
    public void print()
    {
        StdOut.println(Arrays.toString(heights));
        StdOut.println(Arrays.toString(id));
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        HeightQuickUnionUF uf = new HeightQuickUnionUF(N);
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
            uf.print();

        }
        StdOut.println(uf.count() + " components");
    }
}
