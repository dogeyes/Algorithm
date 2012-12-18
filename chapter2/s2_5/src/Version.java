import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午3:59
 * To change this template use File | Settings | File Templates.
 */
public class Version implements Comparable<Version> {
    private int first;
    private int second;
    private int third;
    public Version(String version)
    {
        String[] s = version.split(".");
        first = Integer.parseInt(s[0]);
        second = Integer.parseInt(s[1]);
        third = Integer.parseInt(s[2]);
    }
    public Version(int a, int b, int c)
    {
        first = a;
        second = b;
        third = c;
    }
    public int compareTo(Version that)
    {
        if(first - that.first != 0)
            return first - that.first;
        else if(second - that.second != 0)
            return second - that.second;
        else
            return third - that.third;
    }
    public String toString()
    {
        return first + "." + second + "." + third;
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Version[] versions = new Version[N];
        for(int i = 0; i < N; ++i)
        {
            versions[i] = new Version(StdRandom.uniform(1,10), StdRandom.uniform(1,20), StdRandom.uniform(1, 10));
        }
        Arrays.sort(versions);
        StdOut.println(Arrays.toString(versions));
    }

}
