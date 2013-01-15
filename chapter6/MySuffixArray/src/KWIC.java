/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-15
 * Time: 下午1:34
 * To change this template use File | Settings | File Templates.
 */
public class KWIC {
    public static void main(String[] args)
    {
        In in = new In("tale.txt");
        int context = StdIn.readInt();
        StdIn.readLine();
        StdOut.println(context);
        String text = in.readAll().replaceAll("\\s+", " ");
        int N = text.length();
        MySuffixArray sa = new MySuffixArray(text);

        while (StdIn.hasNextLine())
        {
            String q = StdIn.readLine();
            StdOut.println(q);
            StdOut.println(sa.select(sa.rank(q)));
            for(int i = sa.rank(q); i < N && sa.select(i).startsWith(q); ++i)
            {
                int from = Math.max(0, sa.index(i) - context);
                int to = Math.min(N, from + q.length() + 2 * context);
                StdOut.println(text.substring(from, to));
            }
        }
    }
}
