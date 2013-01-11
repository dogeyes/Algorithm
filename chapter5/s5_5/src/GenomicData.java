import org.jcp.xml.dsig.internal.dom.DOMBase64Transform;
import sun.security.x509.DNSName;

/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-11
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
public class GenomicData{
    public static void compress()
    {
        Alphabet DNA = new Alphabet("ATCG");
        BinaryIn in = new BinaryIn("genomeVirus.txt");
        String s = in.readString();
        int N = s.length();

        BinaryOut out = new BinaryOut("binary.txt");
        out.write(N);
        for(int i = 0; i < N; ++i)
        {
            int d = DNA.toIndex(s.charAt(i));
            out.write(d, DNA.lgR());
        }
        out.close();
    }
    public static void expand()
    {
        Alphabet DNA = new Alphabet("ATCG");
        int w = DNA.lgR();
        BinaryIn in = new BinaryIn("binary.txt");
        BinaryOut out = new BinaryOut("binary.out");
        int N = in.readInt();
        for(int i = 0; i < N; ++i)
        {
            char c = in.readChar(w);
            out.write(DNA.toChar(c));
        }
        out.close();
    }
    public static void main(String[] args)
    {
        compress();
        expand();
    }
}
