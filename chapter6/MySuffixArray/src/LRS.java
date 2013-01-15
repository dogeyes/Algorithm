/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-15
 * Time: 下午1:31
 * To change this template use File | Settings | File Templates.
 */
public class LRS {
    public static void main(String[] args)
    {
        In in = new In("tale.txt");
        String text = in.readAll();

        MySuffixArray sa = new MySuffixArray(text);

        int max = 0;
        int index = 0;
        for(int i = 1; i < sa.length(); ++i)
        {
            int lcp = sa.lcp(i);
            if(lcp > max)
            {
                max = lcp;
                index = i;
            }
        }

        StdOut.println(max);
        StdOut.println(sa.select(index).substring(0, max));
    }
}
