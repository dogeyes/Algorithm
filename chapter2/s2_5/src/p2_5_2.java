import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
public class p2_5_2 {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        String[] strings = new String[N];
        for(int i = 0; i < N; ++i)
            strings[i] = StdIn.readString();
        Arrays.sort(strings);

        for(int i = 0; i < N; ++i)
        {
            for(int j = i + 1; j < N; ++j)
            {
                if(strings[j].length() > strings[i].length() && strings[j].substring(0, strings[i].length()).equals(strings[i]))
                {
                    if(Arrays.binarySearch(strings, strings[j].substring(strings[i].length(), strings[j].length())) >= 0)
                        StdOut.println(strings[j]);
                }
                else
                    break;
            }
        }
        StdOut.println(Arrays.binarySearch(strings, new String("bc")));
    }
}
