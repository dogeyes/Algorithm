/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午8:30
 * To change this template use File | Settings | File Templates.
 */
public class p5_3_4 {
    public static void main(String[] args)
    {
        String txt = StdIn.readLine();
        int M = StdIn.readInt();
        int count = 0;
        int N = txt.length();
        for(int i = 0; i < N; ++i)
        {
            if(txt.charAt(i) == ' ')
                count++;
            else
                count = 0;
            if(count == M)
            {
                StdOut.println(i - M + 1);
                break;
            }
        }
    }
}
