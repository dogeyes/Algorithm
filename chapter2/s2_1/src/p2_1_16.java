import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-26
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public class p2_1_16 {
    public static boolean check(String alg, Comparable[] a)
    {
        Comparable[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        if(alg.equals("Insertion")) InsertionSort.sort(a);
        else if(alg.equals("Selection")) SelectionSort.sort(a);
        else if(alg.equals("Shell")) ShellSort.sort(a);
        if(Arrays.equals(copy, a))
            return true;
        return false;
    }
    public static void main(String[] args)
    {
        int N = 100;
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; ++i)
            a[i] = StdRandom.uniform(0,N);
        StdRandom.shuffle(a);
        StdOut.println(check(new String("Shell"), a));
    }
}
