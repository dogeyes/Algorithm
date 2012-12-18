/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 下午1:05
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_30 {
    public static int gcd(int a, int b)
    {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        boolean[][] a = new boolean[N][N];

        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                if(gcd(i, j) == 1)
                    a[i][j] = true;

        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
                if(a[i][j])
                    StdOut.print('*');
                else
                    StdOut.print(' ');
            StdOut.println();
        }

    }
}
