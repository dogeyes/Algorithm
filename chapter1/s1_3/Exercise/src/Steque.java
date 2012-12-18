/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午12:34
 * To change this template use File | Settings | File Templates.
 */
public class Steque<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public int size()
    {
        return N;
    }

    public  void push(Item item)
    {
        Node oldfisrt = first;
        first = new Node();
        first.item = item;
        first.next = oldfisrt;
        if(oldfisrt == null)
            last  = first;
        N++;
    }
    public Item pop()
    {
        if(isEmpty())
            return null;
        Node oldfisrt = first;
        first = first.next;
        if(first == null)
            last = null;
        N--;
        return oldfisrt.item;
    }
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
       if(oldlast == null)
       {
           first = last;
       }
       else
       {
           oldlast.next = last;
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
        Steque<Integer> steque = new Steque<Integer>();
        Integer i = StdIn.readInt();
        while (i  != 0)
        {
            steque.push(i);
            i = StdIn.readInt();
        }
        steque.print();
        i = StdIn.readInt();
        while (i != 0)
        {
            steque.enqueue(i);
            i = StdIn.readInt();
        }
        steque.print();
        while (!steque.isEmpty())
        {
            StdOut.println(steque.pop() + " ");
        }
        StdOut.println();
    }
}
