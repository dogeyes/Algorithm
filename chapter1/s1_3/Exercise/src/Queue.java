/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午6:53
 * To change this template use File | Settings | File Templates.
 */
public class Queue<Item extends Comparable<Item>> {
    private Node first;
    private Node last;
    private int size;
    private class Node
    {
        Item item;
        Node next;
    }
    public Queue()
    {

    }
    public Queue(Queue<Item> other)
    {
        first = new Node();
        Node pointThis = first;
        Node pointOther = other.first;
        while (pointOther != other.last)
        {
            pointThis.item = pointOther.item;
            pointOther = pointOther.next;
            pointThis.next = new Node();
            pointThis = pointThis.next;
        }
        pointThis.item = pointOther.item;
        last = pointThis;
        size = other.size();
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return size;
    }
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        size++;
        if(isEmpty())
            first = last;
        else oldlast.next = last;
    }
    public Item dequeue()
    {
        Node oldfirst = first;
        first = first.next;
        if(isEmpty())
        {
            last = null;
        }
        size --;
        return oldfirst.item;
    }
    public void delete(int k)
    {
        int count = 0;
        Node point = first;
        while(point.next.next != null && count < k - 2)
        {
            point = point.next;
            count++;
        }
        if(k == 1 && point == first)
            first = first.next;
        else if(count == k - 2)
            point.next = point.next.next;
    }
    public boolean find(Item item)
    {
        Node point = first;
        while (point!= null)
        {
            if(point.item.equals(item))
                return true;
            point = point.next;
        }
        return false;
    }
    public void removeAfter(Item item)
    {
        Node point = first;
        while (point!= null)
        {
            if(point.item.equals(item))
            {
                point.next = null;
                return;
            }
            point = point.next;
        }
    }
    public void insertAfter(Item item1, Item item2)
    {
        Node point = first;
        while (point!= null)
        {
            if(point.item.equals(item1))
            {
                Node newNode = new Node();
                newNode.item = item2;
                newNode.next = point.next;
                point.next = newNode;
                return;
            }
            point = point.next;
        }
    }
    public void remove(Item item)
    {
        Node point = first;
        while(point != null && point.next != null)
        {
            if(point.next.item.equals(item))
                point.next = point.next.next;
            else point = point.next;
        }
        if(first.item.equals(item))
            first = first.next;

    }
    public Item max()
    {
        Node point = first;
        if(isEmpty())
            return null;
        Item max = first.item;
        point = point.next;
        while (point != null)
        {
            if(point.item.compareTo(max) > 0)
                max = point.item;
            point = point.next;
        }
        return max;
    }
    public Item recursiveMax()
    {
        return recursive(first);
    }
    private Item recursive(Node start)
    {
        if(start == null)
            return null;
        Item max = recursive(start.next);
        if(max == null || start.item.compareTo(max) > 0)
            return start.item;
        else return max;
    }
    public void print()
    {
        Node now = first;
        while(now != null)
        {
            StdOut.print(now.item + " ");
            now = now.next;
        }
        StdOut.println();
    }
}
