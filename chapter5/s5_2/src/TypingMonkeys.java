/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-6
 * Time: 下午6:15
 * To change this template use File | Settings | File Templates.
 */
public class TypingMonkeys {
    public static void main(String[] args)
    {
        double p = StdIn.readDouble();
        int N = StdIn.readInt();

        MyStringSET set = new MyStringSET();
        for(int i = 0; i < N; ++i)
        {
            String s = "";
            while (true)
            {
                int t = (int)(StdRandom.uniform() / p);
                if(t >= 0 && t < 26)
                    s += (t + 'a');
                else
                    break;
            }
            set.add(s);
        }

        int sum = 0;
        for(String s: set.keys())
        {
            sum += s.length();
        }
        StdOut.println((double)sum / N);
        StdOut.println(1.0 / (1.0 - p * 26));
    }
}
