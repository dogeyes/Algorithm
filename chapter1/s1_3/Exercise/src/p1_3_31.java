/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_31 {
    public static void main(String[] args)
    {
        DoubleLink<Integer> link = new DoubleLink<Integer>();
        Integer i = StdIn.readInt();
        while (i != 0)
        {
            link.insertBegin(i);
            i = StdIn.readInt();
        }
        link.print();
        link.insertBefore(5, 10);
        link.print();
        link.insertAfter(9, 12);
        link.print();
        link.remove(6);
        link.print();
    }
}

class DoubleLink<Item>
{
    private DoubleNode first;
    private int N;
    public DoubleLink()
    {
        first = new DoubleNode();
        first.next = first;
        first.previous = first;
    }
    private class DoubleNode
    {
        Item item;
        DoubleNode previous;
        DoubleNode next;
    }
    public int size()
    {
        return N;
    }
    public boolean isEmpty()
    {
        return first.next == first;
    }
    public void insertBegin(Item item)
    {
        N++;
        DoubleNode node = new DoubleNode();
        node.item = item;
        node.next = first.next;
        node.previous = first;
        first.next.previous = node;
        first.next = node;
    }
    public void insertEnd(Item item)
    {
        N++;
        DoubleNode node = new DoubleNode();
        node.item = item;
        node.next = first;
        node.previous = first.previous;
        first.previous.next = node;
        first.previous = node;
    }
    public Item removeBegin()
    {
        if(isEmpty())
            return null;
        N--;
        DoubleNode node = first.next;
        node.next.previous = first;
        first.next = node.next;
        return node.item;
    }
    public Item removeEnd()
    {
        if(isEmpty())
            return null;
        N--;
        DoubleNode node = first.previous;
        node.previous.next = first;
        first.previous = node.previous;
        return node.item;
    }
    private DoubleNode find(Item item)
    {
        DoubleNode point = first.next;
        while(point != first)
        {
            if(point.item.equals(item))
            {
                return point;
            }
            point = point.next;
        }
        return  null;
    }

    public void insertAfter(Item item, Item itemi)
    {
        DoubleNode point = find(item);
        if(point == null)
            return;
        DoubleNode node = new DoubleNode();
        node.item  = itemi;
        node.previous = point;
        node.next = point.next;
        point.next.previous = node;
        point.next = node;
        N++;
    }
    public void insertBefore(Item item, Item itemi)
    {
        DoubleNode point = find(item);
        if(point == null)
            return;
        DoubleNode node = new DoubleNode();
        node.item = itemi;
        node.next = point;
        node.previous = point.previous;
        point.previous.next = node;
        point.previous = node;
        N++;
    }
    public void remove(Item item)
    {
        DoubleNode point = find(item);
        if(point == null)
            return;
        point.next.previous = point.previous;
        point.previous.next = point.next;
        N--;
        return;
    }
    public void print()
    {
        DoubleNode point = first.next;
        while(point != first)
        {
            StdOut.print(point.item +" ");
            point = point.next;
        }
        StdOut.println();
    }
}
