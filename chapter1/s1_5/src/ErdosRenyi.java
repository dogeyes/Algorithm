/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-26
 * Time: 上午12:04
 * To change this template use File | Settings | File Templates.
 */
public class ErdosRenyi {
    public static void main(String[] args)
    {
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        for(int N = 10; true; N += N)
            StdDraw.point(Math.log(N), Math.log(count(N)));

    }
    public static int count(int N)
    {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int count = 0;
        while (uf.count() > 1)
        {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            count++;
            if(uf.connected(p, q))
                continue;
            uf.union(p, q);
        }
        return count;
    }
}
