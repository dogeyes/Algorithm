/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-11
 * Time: 下午12:39
 * To change this template use File | Settings | File Templates.
 */
public class MyClearLZW {
    private static final int R = 256;
    private static final int L = 4096;
    private static final int W = 12;

    public static void compress()
    {
        TST<Integer> tst = new TST<Integer>();
        BinaryIn in = new BinaryIn("tale.txt");
        BinaryOut out = new BinaryOut("binary.txt");
        String input = in.readString();

        for(char c = 0; c < R; ++c)
            tst.put(c + "", (int)c);

        int cnt = R + 1;
        for(int i = 0; i < input.length();)
        {
            String s = tst.longestPrefixOf(input.substring(i));
            i = i + s.length();
            out.write(tst.get(s), W);
            if(cnt < L && i < input.length() - 1)
                tst.put(s + input.charAt(i), cnt++);
            if(cnt == L)
            {
                tst = new TST<Integer>();
                for(char c = 0; c < R; ++c)
                    tst.put(c + "", (int)c);
                cnt = R+1;
            }
        }
        out.write(R, W);
        out.close();
    }
    public static void expand()
    {
        BinaryIn in = new BinaryIn("binary.txt");
        BinaryOut out = new BinaryOut("binary.out");
        String[] st = new String[L];

        int i;
        for(i = 0; i < R; ++i)
            st[i] = (char)i + "";
        i++;
        int codeword = in.readInt(W);
        String val = st[codeword];
        while (true)
        {
            out.write(val);
            if(i == L)
            {
                st = new String[L];
                for(i = 0; i < R; ++i)
                    st[i] = (char)i + "";
                i++;
            }
            codeword = in.readInt(W);
            if(codeword == R)
                break;
            String s = st[codeword];
            if(i == codeword)
                s = val + val.charAt(0);
            if(i < L)
                st[i++] = val + s.charAt(0);
            val = s;
        }
        out.close();
    }
    public static void main(String[] args)
    {
        compress();
        expand();
    }
}
