/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-19
 * Time: 下午7:43
 * To change this template use File | Settings | File Templates.
 */
public class p3_3_16 {
    public static void main(String[] args)
    {
        MyRedBlackBST<String, Integer> bst = new MyRedBlackBST<String, Integer>();
        int N = StdIn.readInt();
        for(int i = 0; i < N; ++i)
        {
            String s = StdIn.readString();
            bst.put(s, i);
        }
        bst.draw();
    }
}
