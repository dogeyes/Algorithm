/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-25
 * Time: 下午9:07
 * To change this template use File | Settings | File Templates.
 */
public class p1_4_43 {
    public static double resizingArrays(int N)
    {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>();
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < N; ++i)
            stack.push(i);
        return timer.elapsedTime();
    }
    public static double linkedList(int N)
    {
        Stack<Integer> stack = new Stack<Integer>();
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < N; ++i)
            stack.push(i);
        return timer.elapsedTime();
    }
    public static void main(String[] args)
    {
        int N =  250;
        for(;true; N += N)
        {
            StdOut.println(N + " " + resizingArrays(N) / linkedList(N));
        }
    }
}
