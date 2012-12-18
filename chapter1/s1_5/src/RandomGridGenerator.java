/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午9:03
 * To change this template use File | Settings | File Templates.
 */
public class RandomGridGenerator {
    private static class Connection
    {
        int p;
        int q;
        public Connection(int p, int q)
        {
            this.p = p;
            this.q = q;
        }
    }
    public static RandomBag<Connection> generator(int N)
    {
        RandomBag<Connection> bag = new RandomBag<Connection>();
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
            {
                if(i > 0)
                {
                    bag.add(new Connection(tran(i - 1, j, N), tran(i, j, N)));
                    bag.add(new Connection(tran(i, j, N), tran(i - 1, j, N)));
                }
                if(i < N - 1)
                {
                    bag.add(new Connection(tran(i + 1, j, N), tran(i, j, N)));
                    bag.add(new Connection(tran(i, j, N), tran(i + 1, j, N)));
                }
                if(j > 0)
                {
                    bag.add(new Connection(tran(i, j - 1, N), tran(i, j, N)));
                    bag.add(new Connection(tran(i, j, N), tran(i, j - 1, N)));
                }
                if(j < N - 1)
                {
                    bag.add(new Connection(tran(i, j + 1, N), tran(i, j, N)));
                    bag.add(new Connection(tran(i, j, N), tran(i, j + 1, N)));
                }
            }
        return bag;
    }
    private static int tran(int i, int j, int N)
    {
        return i * N + j;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        RandomBag<Connection> bag = generator(N);
        DynamicGrowthWeightedQuickUnionUF uf = new DynamicGrowthWeightedQuickUnionUF();
        StdDraw.setScale(0, N);
        StdDraw.setPenRadius(0.005);

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(0.005);
        for(int i = 0; i < bag.size(); ++i)
        {
            if(uf.connected(bag.at(i).p, bag.at(i).q))
                continue;
            uf.union(bag.at(i).p, bag.at(i).q);
            StdDraw.line(bag.at(i).p / N, bag.at(i).p % N,bag.at(i).q / N, bag.at(i).q % N );
        }
        for(int i = 0; i < N; ++ i)
            for(int j = 0; j < N; ++ j)
            {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.setPenRadius(0.01);
                StdDraw.point(i, j);
            }
    }
}
