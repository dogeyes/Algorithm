/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-11
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
public class RLE {
    public static void compress()
    {
        BinaryIn in = new BinaryIn("a.txt");
        BinaryOut out = new BinaryOut("binary.txt");
        Alphabet alphabet = new Alphabet("a");

        out.write(alphabet.R());
        for(int i = 0; i < alphabet.R(); ++i)
        {
            out.write(alphabet.toChar(i));
        }

        char c = in.readChar();
        int cnt = 1;
        while (!in.isEmpty())
        {
            char input = in.readChar();
            if(c != input)
            {
                out.write(alphabet.toIndex(c));
                out.write(cnt);
                cnt = 1;
                c = input;
            }
            else
            {
                cnt++;
            }
        }
        out.write(alphabet.toIndex(c));
        out.write(cnt);
        out.close();
    }
    public static void expand()
    {
        BinaryIn in = new BinaryIn("binary.txt");
        BinaryOut out = new BinaryOut("binary.out");
        String al = "";
        int R = in.readInt();
        for(int i = 0; i < R; ++i)
            al = al + in.readChar();

        Alphabet alphabetp = new Alphabet(al);
        while (!in.isEmpty())
        {
            int index = in.readInt();
            int num = in.readInt();
            for(int i = 0; i < num; ++i)
                out.write(alphabetp.toChar(index));
        }
        out.close();
    }
    public static void main(String[] agrs)
    {
        compress();
        expand();
    }
}
