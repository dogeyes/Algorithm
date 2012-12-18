import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午3:29
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_15 {
    public static int twoFasterSum(int[] a)
    {
        int cnt = 0;
        Arrays.sort(a);
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi)
        {
            if(a[lo] + a[hi] == 0)
            {
                cnt ++;
                lo++;
                hi--;
            }
            else if(a[lo] + a[hi] < 0)
                lo++;
            else
                hi--;
        }
        return cnt;
    }
    public static int threeFasterSum(int[] a)
    {
        Arrays.sort(a);
        int cnt = 0;
        for(int i = 0; i < a.length; ++i)
        {
            int lo = i + 1;
            int hi = a.length - 1;
            while(lo < hi)
            {
                if(a[lo] + a[hi] + a[i] == 0)
                {
                    cnt++;
                    lo++;
                    hi--;
                }
                else if(a[lo] + a[hi] + a[i] < 0)
                    lo++;
                else
                    hi--;
            }
        }
        return cnt;
    }
    public static int[] randomGenerate(int N)
    {
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = StdRandom.uniform(-N, N);
        return a;
    }
    public static void main(String[] args)
    {
        String file = StdIn.readString();
        int[] a = In.readInts(file);
        StdOut.println(threeFasterSum(a));

    }
}
