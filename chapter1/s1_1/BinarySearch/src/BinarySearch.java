import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 上午10:11
 * To change this template use File | Settings | File Templates.
 */

public class BinarySearch {
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if(key < a[mid])
                hi = mid - 1;
            else if(key > a[mid])
                lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] whiteList = In.readInts("in.txt");
        Arrays.sort(whiteList);
        for(int i : whiteList)
            StdOut.print(i + " ");
        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(rank(key, whiteList) == -1)
                StdOut.println(key);
        }
    }
}

