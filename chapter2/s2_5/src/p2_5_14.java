import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
public class p2_5_14 {
    private static class Domain implements Comparable<Domain>
    {
        private String domain;
        public Domain(String name)
        {
            domain = name;
        }
        public int compareTo(Domain that)
        {
            return reverse(domain).compareTo(reverse(that.domain));
        }
        private String reverse(String name)
        {
            String[] s = name.split("\\.");
            return s[2] +"." + s[1] + "." +s[0];
        }
        public String toString()
        {
            return domain;
        }
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Domain[] domains = new Domain[N];
        for(int i = 0; i < N; ++i)
        {
            String s = StdIn.readString();
            domains[i] = new Domain(s);
        }
        Arrays.sort(domains);
        StdOut.println(Arrays.toString(domains));
    }
}
