/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-11
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
public class RunLengthEncoding {
    public static void compress()
    {
        char cnt = 0;
        BinaryIn in = new BinaryIn("random.txt");
        BinaryOut out = new BinaryOut("binary.txt");

        boolean pre = false;
        while (!in.isEmpty())
        {
            boolean  b = in.readBoolean();
            if(b != pre)
            {
                out.write(cnt);
                cnt = 0;
                pre = b;
            }
            else
            {
                if(cnt == 255)
                {
                    out.write(cnt);
                    cnt = 0;
                    out.write(0);
                }
            }
            cnt++;
        }
        out.write(cnt);
        out.close();
    }
    public static void expand()
    {
        boolean b = false;
        BinaryIn in = new BinaryIn("binary.txt");
        BinaryOut out = new BinaryOut("binary.out");
        while (!in.isEmpty())
        {
            int d = in.readChar();
            for(int i = 0; i < d; ++i)
                out.write(b);
            b = !b;
        }
        out.close();
    }
    public static void main(String[] args)
    {
        compress();
        expand();
    }
}
