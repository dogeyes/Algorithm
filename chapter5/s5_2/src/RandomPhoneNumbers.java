/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-6
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public class RandomPhoneNumbers {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MyStringSET set = new MyStringSET();
        for(int i = 0 ; i < N; ++i)
        {
            String s = "";
            for(int j = 0; j < 10; ++j)
                s += StdRandom.uniform(0, 10);
            s = "(" + s.substring(0,3) + ")" + " " + s.substring(3, 6) + "-"  + s.substring(6, 10);
            if(set.contains(s))
                i--;
            else
                set.add(s);
        }
        StdOut.println(set.keys());
    }
}
