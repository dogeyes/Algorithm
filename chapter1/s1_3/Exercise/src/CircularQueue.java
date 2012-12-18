/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
public class CircularQueue<Item> {
    private Node last;
    private int N;
    private class Node
    {
        Item item;
        Node next;
    }
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        N++;
        if(oldlast == null)
        {
            last.next = last;
            return;
        }
        else
        {
            last.next = oldlast.next;
            oldlast.next = last;
        }
    }
    public Item dequeue()
    {
        Node point;
        N--;
        if(last.next == last)
        {
            point = last;
            last = null;
            return point.item;
        }
        point = last.next;
        last.next = last.next.next;
        return  point.item;
    }
    public boolean isEmpty()
    {
        return last == null;
    }
    public int size()
    {
        return N;
    }
}
