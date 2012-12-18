import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Integer[] a = new Integer[10];
        for(int i = 0;i < 10; ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        MergeSort.sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
