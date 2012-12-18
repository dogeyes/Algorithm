import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-24
 * Time: 下午10:28
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_50 {
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < 10; ++i)
            stack.push(i);
        Iterator iterator = stack.iterator();
        iterator.hasNext();
        iterator.next();
        //stack.push(20);
        iterator.next();

    }
}
