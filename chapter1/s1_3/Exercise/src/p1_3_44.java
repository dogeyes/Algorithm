/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_44 {
    public static void main(String[] args)
    {
        Buffer buffer = new Buffer();
        Character c = StdIn.readChar();
        while (c != '!')
        {
            buffer.insert(c);
            c = StdIn.readChar();
        }
        buffer.left(4);
        buffer.delete();
        buffer.delete();
        buffer.right(2);
        buffer.insert('E');
        buffer.insert('G');
        buffer.print();
    }
}
class Buffer
{
    private Stack<Character> forward;
    private Stack<Character> backward;
    public Buffer()
    {
        forward = new Stack<Character>();
        backward = new Stack<Character>();
    }
    public char delete()
    {
        return forward.pop();
    }
    public void insert(char c)
    {
        forward.push(c);
    }
    public void left(int k)
    {
        for(int i = 0; i < k ; ++i)
        {
            backward.push(forward.pop());
        }
    }
    public void right(int k)
    {
        for(int i = 0; i < k; ++i)
            forward.push(backward.pop());
    }
    public int size()
    {
        return forward.size() + backward.size();
    }
    public void print()
    {
        while (! forward.isEmpty())
        {
            backward.push(forward.pop());
        }
        while (! backward.isEmpty())
        {
            StdOut.print(backward.pop());
        }
        StdOut.println();
    }

}
