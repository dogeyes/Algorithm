/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public class MoveToFront<Item> {
    private class Node
    {
        Item item;
        Node next;
    }
    private Node first;
    public void insert(Item item)
    {
        Node point = first;
        first = new Node();
        first.item = item;
        first.next = point;
        point = first;
        while (point != null && point.next != null)
        {
            if(point.next.item.equals(item))
                point.next = point.next.next;
            point = point.next;
        }
    }
    public void print()
    {
        Node point = first;
        while (point != null)
        {
            StdOut.print(point.item + " ");
            point = point.next;
        }
        StdOut.println();
    }
    public static void main(String[] args)
    {
        MoveToFront<Character> queue = new MoveToFront<Character>();
        char in = StdIn.readChar();
        while (in != '!')
        {
            if(in != '\n')
            {
                queue.insert(in);
                queue.print();
            }
            in = StdIn.readChar();
        }
    }
}
