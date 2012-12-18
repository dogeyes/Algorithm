import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 下午12:52
 * To change this template use File | Settings | File Templates.
 */
public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private int count;

    private class Node
    {
        private Item item;
        private Node next;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        count++;
        N++;
    }
    public Item pop()
    {
        Node oldfirst = first;
        first = first.next;
        count++;
        return oldfirst.item;
    }
    public int size()
    {
        return N;
    }
    public Item peek()
    {
        return first.item;
    }
    public Iterator<Item> iterator()
    {
        return new Iterator<Item>() {
            Node iter = first;
            final int count_record = count;
            @Override
            public boolean hasNext() {
                if(count != count_record)
                    throw new ConcurrentModificationException();
                return iter != null;
            }

            @Override
            public Item next() {
                if(count != count_record)
                    throw new ConcurrentModificationException();
                Item item = iter.item;
                iter = iter.next;
                return item;
            }

            @Override
            public void remove() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
    public void print()
    {
        for(Node start = first; start != null; start = start.next)
            StdOut.print(start.item + " ");
        StdOut.println();
    }
}
