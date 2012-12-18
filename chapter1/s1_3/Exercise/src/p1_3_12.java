import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午7:30
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_12 {
    public static Stack<String> copy(Stack<String> source)
    {
        Stack<String> dest = new Stack<String>();
        Iterator<String> iter = source.iterator();
        while(iter.hasNext())
        {
            dest.push(iter.next());
        }
        return dest;
    }
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        String source = StdIn.readString();
        while(!source.equals("!"))
        {
            stack.push(source);
            source = StdIn.readString();
        }
        Stack<String> dest = copy(stack);
        dest.push("test");
        dest.print();
        stack.print();
    }
}
