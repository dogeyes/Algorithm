/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-11
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public class HuffmanCompression {
    private static int R = 256;
    private static class Node implements Comparable<Node>
    {
        private char ch;
        private int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right)
        {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
        public boolean isLeaf()
        {
            return left == null && right == null;
        }
        public int compareTo(Node that)
        {
            return freq - that.freq;
        }
    }
    public static void expand()
    {
        BinaryIn in = new BinaryIn("binary.txt");
        BinaryOut out = new BinaryOut("binary.out");
        Node root = readTrie(in);
        int N = in.readInt();
        for(int i = 0; i < N; ++i)
        {
            Node x = root;
            while (!x.isLeaf())
            {
                if(in.readBoolean())
                    x = x.right;
                else
                    x = x.left;
            }
            out.write(x.ch);
        }
        out.close();
    }
    private static Node readTrie(BinaryIn in)
    {
        if(in.readBoolean())
            return new Node(in.readChar(), 0, null, null);
        else
            return new Node('\0', 0, readTrie(in), readTrie(in));
    }

    private static void writeTrie(Node x, BinaryOut out)
    {
        if(x.isLeaf())
        {
            out.write(true);
            out.write(x.ch);
            return;
        }
        out.write(false);
        writeTrie(x.left, out);
        writeTrie(x.right, out);
    }
    private static Node buildTrie(int[] freq)
    {
        MinPQ<Node> pq = new MinPQ<Node>();
        for(int i = 0; i < freq.length; ++i)
        {
            if(freq[i] != 0)
                pq.insert(new Node((char)i, freq[i], null, null));
        }
        while (pq.size() > 1)
        {
            Node x = pq.delMin();
            Node y = pq.delMin();
            pq.insert(new Node('\0', x.freq + y.freq, x, y));
        }
        return pq.delMin();
    }
    private static String[] buildCode(Node root)
    {
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }
    private static void buildCode(String[] st, Node x, String s)
    {
        if(x.isLeaf())
        {
            st[x.ch] = s;
            return;
        }
        buildCode(st, x.left, s + "0");
        buildCode(st, x.right, s + "1");
    }
    public static void compress()
    {
        BinaryIn in = new BinaryIn("random.txt");
        BinaryOut out = new BinaryOut("binary.txt");

        String s = in.readString();
        char[] input = s.toCharArray();

        int[] freq = new int[R];
        for(int i = 0; i < input.length; ++i)
            freq[input[i]]++;

        Node trie = buildTrie(freq);
        String[] table = buildCode(trie);
        writeTrie(trie, out);
        out.write(input.length);
        for(int i = 0; i < input.length; ++i)
        {
            s = table[input[i]];
            for(int j = 0; j < s.length(); ++j)
                out.write(s.charAt(j) == '1');
        }
        out.close();
    }
    public static void main(String[] args)
    {
        compress();
        expand();
    }
}
