/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-14
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
public class TestBTreeSET {
    public static void main(String[] args)
    {
        BTreeSET<Character> bTree = new BTreeSET<Character>('*');
        for(int i = 0; i < 100; ++i)
        {
            bTree.add((char)(StdRandom.uniform(26) + 'A'));
        }

        bTree.print();
    }
}
