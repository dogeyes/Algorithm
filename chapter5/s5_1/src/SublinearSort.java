import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class SublinearSort {
    public static void LSDSort(int[] a)
    {
        int div = 4;
        int R = (int) Math.pow(2, div) ;
        int W = 16 / div;
        int mask = 16;
        int N = a.length;
        int[] aux = new int[N];
        for(int i = 0; i < W; ++ i)
        {
            int[] count = new int[R + 1];
            for(int j  = 0; j < N; ++j)
            {
                count[((a[j] >> mask) & (R - 1)) + 1]++;
            }
            for(int j = 1; j < R + 1; ++j)
                count[j] += count[j - 1];
            for(int j = 0; j < N; ++j)
                aux[count[(a[j] >> mask) & (R - 1)]++] = a[j];

            for(int j = 0; j < N; ++j)
                a[j] = aux[j];

            mask+= div;
        }

        StdOut.println(Arrays.toString(a));

        insertionSort(a);
        StdOut.println(Arrays.toString(a));
    }

    public static void LSDSort2(int[] a)
    {
        int R = 65536;
        int N = a.length;
        int[] aux = new int[N];
        int[] count = new int[R + 1];
        for(int i = 0; i < N; ++i)
            count[((a[i] >> 16 )&((1<<16) - 1)) + 1]++;
        for(int i = 1; i < R + 1; ++i)
            count[i] += count[i - 1];
        for(int i = 0; i < N; ++i)
            aux[count[(a[i] >> 16 )&((1<<16) - 1)]++] = a[i];
        for(int i = 0; i < N; ++i)
            a[i] = aux[i];
        StdOut.println(Arrays.toString(a));
        insertionSort(a);
        StdOut.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] a)
    {
        int N = a.length;
        for(int i = 0; i < N; ++i)
            for(int j = i; j > 0 && a[j] < a[j - 1]; --j)
            {
                int tmp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = tmp;
            }
    }

    public static void main(String[] args)
    {
        int N = 100;
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = (N - i) << 16;
        LSDSort(a);
    }
}
