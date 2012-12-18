/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午2:20
 * To change this template use File | Settings | File Templates.
 */
public class p3_1_1 {
    public static void main(String[] args)
    {
        MyBinarySearchST<String, Double> st = new MyBinarySearchST<String, Double>(12);
        In in = new In("grad2score.txt");
        while (!in.isEmpty())
        {
            String s = in.readString();
            Double d = in.readDouble();
            st.put(s, d);
        }
        int N = StdIn.readInt();
        double sum = 0;
        for(int i = 0; i < N; ++i)
        {
            String s = StdIn.readString();
            sum += st.get(s);
        }
        StdOut.println(sum / N);
    }
}
