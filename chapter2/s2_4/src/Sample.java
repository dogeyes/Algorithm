import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-12
 * Time: 下午1:24
 * To change this template use File | Settings | File Templates.
 */
public class Sample {
    private int[] p;
    private int[] sum;
    private int N;
    public Sample(int[] a)
    {
        N = a.length;
        sum = new int[N + 1];
        p = new int[N + 1];
        for(int i = 1; i <= N; ++i)
        {
            p[i] = a[i - 1];
            sum[i] = a[i - 1];
        }
        for(int i = N / 2; i >= 1; --i)
        {
            sum[i] += sum[i * 2];
            if(2 * i < N) sum[i] += sum[i * 2 + 1];
        }
    }
    public int random()
    {
        int T = sum[1];
        int t = StdRandom.uniform(0, T) + 1;
        int i = 1;
        while(true)
        {
            if(i * 2 <= N &&  t <= sum[i * 2])
            {
                i = i * 2;
            }
            else if(i * 2 < N && t <= sum[i * 2] + sum[i * 2 + 1])
            {
                t = t - sum[i*2];
                 i = i * 2 + 1;
            }
            else
                return i;
        }
    }
    public void change(int i, int v)
    {
        int tmp = p[i];
        p[i] = v;
        while(i >= 1)
        {
            sum[i] += v - tmp;
            i = i / 2;
        }
    }
    public static void main(String[] args)
    {
        int N = 10;
        int[] a = new int[N];
        int[] count = new int[N  +1];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        Sample sample = new Sample(a);
        for(int i = 0; i < 10000 * N; ++i)
        {
            int tmp = sample.random();
            count[tmp] ++;
            StdOut.print(tmp + " ");
        }
        StdOut.println();
        StdOut.println(Arrays.toString(count));

        count = new int[N  +1];
        for(int i = 1; i <= N; ++i)
            sample.change(i, 1);
        for(int i = 0; i < 1000 * N; ++i)
        {
            int tmp = sample.random();
            StdOut.print(tmp + " ");
            count[tmp] ++;
        }
        StdOut.println();
        StdOut.println(Arrays.toString(count));
    }
}
