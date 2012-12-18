import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_12 {
    public static void intersection(int[] a, int[] b)
    {
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length)
        {
            if(a[i] == b[j])
            {
                StdOut.print(" " + a[i]);
                i++;
                j++;
            }
            else if(a[i] > b[j])
                    j++;
            else if(a[i] < b[j])
                    i++;
        }
    }
    public static int[] randomGenerate(int N)
    {
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = StdRandom.uniform(0, N);
        return a;
    }
    public static void main(String[] args)
    {
        int[] a = randomGenerate(100);
        int[] b = randomGenerate(100);
        Arrays.sort(a);
        Arrays.sort(b);
        StdOut.println(Arrays.toString(a));
        StdOut.println(Arrays.toString(b));
        intersection(a, b);
    }

}
