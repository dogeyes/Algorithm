import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-3
 * Time: 下午2:46
 * To change this template use File | Settings | File Templates.
 */
public class MyAlphabet {
    private String index2char;
    private int N;
    private int lgN;
    private ST<Character, Integer>  char2index;
    public MyAlphabet(String s)
    {
        index2char = s;
        char2index = new ST<Character, Integer>();
        N = s.length();
        lgN = (int) Math.log(N) + 1;
        for(int i = 0; i < N; ++i)
            char2index.put(s.charAt(i), i);
    }
    public char toChar(int index)
    {
        return index2char.charAt(index);
    }
    public int toIndex(char c)
    {
        return char2index.get(c);
    }
    public boolean contains(char c)
    {
        return char2index.contains(c);
    }
    public int R()
    {
        return N;
    }
    public int lgR()
    {
        return lgN;
    }
    public int[] toIndices(String s)
    {
        int[] a = new int[s.length()];
        for(int i = 0; i < s.length(); ++i)
            a[i] = toIndex(s.charAt(i));
        return a;
    }
    public String toChars(int[] indices)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < indices.length; ++i)
            sb.append(toChar(indices[i]));
         return sb.toString();
    }
    public static void main(String[] args)
    {
        MyAlphabet alphabet = new MyAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        In in = new In("abra.txt");
        String s = in.readString();
        int[] a = alphabet.toIndices(s);
        StdOut.println(Arrays.toString(a));
    }
}
