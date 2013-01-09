/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午10:27
 * To change this template use File | Settings | File Templates.
 */
public class TandemRepeatSearch {
    public static void main(String[] args)
    {
        int max = 0;
        String pat = StdIn.readString();
        String txt = StdIn.readString();

        MyKMPSubStringSearch kmp = new MyKMPSubStringSearch(pat);
        Iterable<Integer> index = kmp.searchAll(txt);
        int count = 1;
        int M = pat.length();
        StdOut.println(M);
        int pre = txt.length();
        int position = pre;
        int maxP = pre;
        for(int i : index)
        {
            StdOut.print(i + " ");
            if(i - pre == M)
                count++;
            else
            {
                count = 1;
                position = i;
            }
            if(count > max)
            {
                max = count;
                maxP = position;
            }
            pre = i;
        }
        StdOut.println();
        StdOut.println(max);
        StdOut.println(maxP);
    }
}
