import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午9:29
 * To change this template use File | Settings | File Templates.
 */
public class DynamicGrowthWeightedQuickUnionUF {
    private int[] id;
    private int[] weights;
    private int count;
    private int size;
    public DynamicGrowthWeightedQuickUnionUF()
    {
        size = 0;
        count = 0;
        id = new int[0];
        weights = new int[0];
    }
    public int count()
    {
        return count;
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    private void resize(int rsize)
    {
        int[] rid = new int[rsize];
        int[] rweights = new int[rsize];
        count = rsize - size + count;
        for(int i = 0; i < rsize; ++i)
        {
            rid[i] = i;
            rweights[i] = 1;
        }
        for(int i = 0; i < size; ++i)
        {
            rid[i] = id[i];
            rweights[i] = weights[i];
        }
        size = rsize;
        weights = rweights;
        id = rid;
    }
    public int find(int p)
    {
        if (p > size)
            resize(p * 2 + 1);

        int count = 0;
        int root = p;
        while(root != id[root])
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
        return root;
    }
    public void union(int p, int q)
    {
        int pId = find(p);
        int qId = find(q);
        if(qId == pId)
            return;
        if(weights[pId] < weights[qId])
        {
            id[pId] = qId;
            weights[qId] += weights[pId];
        }
        else
        {
            id[qId] = pId;
            weights[pId] += weights[qId];
        }
        count--;

    }
    public void print()
    {
        StdOut.println(Arrays.toString(id));
    }
    public static void main(String[] args)
    {
        In in = new In("mediumUF.txt");
        int N = in.readInt();
        DynamicGrowthWeightedQuickUnionUF uf = new DynamicGrowthWeightedQuickUnionUF();
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
