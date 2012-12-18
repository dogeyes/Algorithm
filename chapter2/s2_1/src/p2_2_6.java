
public class p2_2_6 {
    public static int trial(int N, String alg)
    {
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; ++i)
            a[i] = StdRandom.uniform(0, N);
        if(alg.equals("Bottom")) { BottomUpMergeSort.sort(a); return BottomUpMergeSort.count;}
        else { MergeSort.sort(a); return MergeSort.count;}
    }
    public static void main(String[] args)
    {
        StdDraw.setXscale(1, 512);
        StdDraw.setYscale(1, 512 * 6 * 10);
        StdDraw.setPenRadius(0.005);
        for(int i = 1; i < 513; ++i)
        {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, 6 * i * Math.log(i));
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(i, 9 * i * Math.log(i));
            int count = trial(i, "Bottom");
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(i, count);
            count = trial(i, "Merge");
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.point(i, count);
        }
    }
}
