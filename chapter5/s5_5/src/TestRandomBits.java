/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-11
 * Time: 上午9:52
 * To change this template use File | Settings | File Templates.
 */
public class TestRandomBits {
    public static void main(String[] args)
    {
        BinaryOut out = new BinaryOut("random.txt");
        int num = StdIn.readInt();
        for(int i = 0; i < num / 8; ++i)
        {
            out.write(StdRandom.uniform(num) & 0xff, 8);
        }
        out.close();
    }
}
