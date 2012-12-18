import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class UnbiasedElection {
    private static class Name implements Comparable<Name>
    {
        public static int[] order = new int[]{7, 9, 16, 22, 18, 24, 11, 8, 17, 4, 19, 25, 5, 14, 3, 21, 2, 0, 10, 15, 20, 6, 1, 13, 23, 12};
        public String name;
        public Name(String na)
        {
            name = na;
        }
        public int compareTo(Name other)
        {
            int len = Math.min(name.length(), other.name.length());
            for(int i = 0; i < len; ++i)
            {
                if(comp(name.charAt(i), other.name.charAt(i)) != 0)
                    return comp(name.charAt(i), other.name.charAt(i));
            }
            return name.length() - other.name.length();
        }
        private int comp(char a, char b)
        {
            return order[(int)a - 'A'] - order[(int)b - 'A'];
        }
        public String toString()
        {
            return name;
        }
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Name[] names = new Name[N];
        for(int i = 0; i < N; ++i)
        {
            String n = StdIn.readString();
            names[i] = new Name(n);
        }
        Arrays.sort(names);
        StdOut.println(Arrays.toString(names));
    }
}
