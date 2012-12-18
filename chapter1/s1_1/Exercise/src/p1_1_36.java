/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-15
 * Time: 下午11:48
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_36 {
    public static void main(String[] args)
    {
        int M = StdIn.readInt();
        int N = StdIn.readInt();

        int a[] = new int[M];

        int[][] sum = new int[M][M];
        for(int i = 0 ; i < N; ++i)
        {

            for(int l= 0 ; l < a.length; ++l)
                a[l] = l;
            StdRandom.shuffle(a);
            //shuffle(a);
            for(int j = 0 ; j < M; ++j)
                sum[a[j]][j]++;

        }
        for(int i = 0; i < M; ++ i)
        {
            for(int j = 0; j < M; ++j)
                StdOut.print(sum[i][j] + " ");
            StdOut.println();
        }
    }
    static void shuffle(int[] a)
    {
        for(int i = 0; i < a.length; ++i)
        {
            int j = StdRandom.uniform(a.length);
            int k = a[i];
            a[i] = a[j];
            a[j] = k;
        }
    }
}
