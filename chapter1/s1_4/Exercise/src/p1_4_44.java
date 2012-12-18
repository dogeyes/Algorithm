/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午9:11
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_44 {
    public static void main(String[] args)
    {
        int N = 30;
        for(;true; N += N)
        {
            int count = 0;
            for(int j = 0; j < 100; ++j)
            {
                int[] a = new int[N];
                while(true)
                {
                    int tmp = StdRandom.uniform(0, N);
                    count ++;
                    if(a[tmp] == 1)
                        break;
                    a[tmp]  = 1;
                }
            }
            StdOut.println(N + " " + (count / 100) / Math.sqrt(Math.PI * N / 2));
        }
    }
}
