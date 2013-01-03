import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午12:02
 * To change this template use File | Settings | File Templates.
 */
public class KeyIndexedCounting {
    public static void main(String[] args)
    {
        In in = new In("num.txt");
        int n = in.readInt();
        int[] a = new int[n];
        int maxNum = 0;
        for(int i = 0; i < n; ++i)
        {
            a[i] = in.readInt();
            if(a[i] > maxNum)
                maxNum = a[i];
        }
        maxNum++;
        int[] count = new int[maxNum + 1];
        for(int i = 0; i < n; ++i)
            count[a[i] + 1] ++;
        int[] index = new int[maxNum];
        for(int i = 1; i < maxNum; ++i)
            index[i] = count[i] + index[i - 1];
        int[] aux = new int[n];
        for(int i = 0; i < n; ++i)
            aux[index[a[i]]++] = a[i];
        for(int i = 0; i < n; ++i)
            a[i] = aux[i];

        StdOut.println(Arrays.toString(a));
        StdOut.println(Arrays.toString(index));

    }
}
