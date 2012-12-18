import java.util.Arrays;
import java.util.Collections;

public class p1_2_9 {
    public static int rank(int key, int[] a, Counter counter)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            counter.increment();
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
            Counter counter = new Counter("search times");
            int key = StdIn.readInt();
            if(rank(key, whiteList, counter) == -1)
                StdOut.println(key);
            StdOut.println(counter);
        }
    }
}

