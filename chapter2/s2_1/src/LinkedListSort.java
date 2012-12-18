

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-28
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListSort {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        for(int i = 0; i < N; ++i)
            list.enqueue(i);
        list.print();
    }
}

class MyLinkedList<Item extends Comparable<Item>>
{
    private class Node
    {
        public Item item;
        public Node next;
    }
    private Node first;
    private Node last;
    public MyLinkedList()
    {
        first = new Node();
        first.next = null;
        last = first;
    }
    private MyLinkedList(Node first)
    {
        this.first = first;
        last = first;
    }
    private int N;
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        oldlast.next = last;
        N++;
    }
    private void enqueue(Node node)
    {
        Node oldlast = last;
        last = node;
        oldlast.next = last;
        N++;
    }
    public Item dequeue()
    {
        Item item = first.next.item;
        first.next = first.next.next;
        N--;
        if(isEmpty())
            last = first;
        return item;
    }
    public void sort()
    {
        while (true)
        {
            Node prelo = first;
            Node mid = first.next;
            Node hi;
            while(mid != null && mid.next !=null && less(mid, mid.next))
                mid = mid.next;
            if(mid == null || mid.next == null)
                return;
            while (true)
            {
                hi = mid.next;
                while (hi != null && hi.next != null && less(hi, hi.next))
                    hi = hi.next;
                prelo = merge(prelo, mid, hi);
                mid = prelo.next;
                while(mid != null && mid.next !=null && less(mid, mid.next))
                    mid = mid.next;
                if(mid == null || mid.next == null)
                    break;
            }
        }
    }
    private Node merge(Node prelo, Node mid, Node hi)
    {
        Node rest = hi.next;
        Node newListFirst = prelo;
        Node pointNew = prelo;
        Node point1 = prelo.next;
        Node point2 = mid.next;
        while (point1 != mid.next && point2 != hi.next)
            if(less(point1, point2))
            {
                pointNew.next = point1;
                pointNew = pointNew.next;
                point1 = point1.next;
            }
            else
            {
                pointNew.next = point2;
                pointNew = pointNew.next;
                point2 = point2.next;
            }
        if(point1 == mid.next)
        {
            pointNew.next = point2;
            return hi;
        }
        else
        {
            pointNew.next = point1;
            mid.next = rest;
            return mid;
        }

    }
    public boolean less(Node a, Node b)
    {
        return a.item.compareTo(b.item) < 0;
    }

    public void print()
    {
        Node point = first.next;
        while (! (point == null) )
        {
            StdOut.print(point.item + " ");
            point = point.next;
        }
        StdOut.println();
    }
    private void shuffle()
    {
        if(size() <= 1)
            return;
        MyLinkedList<Item> list1 = new MyLinkedList<Item>();
        MyLinkedList<Item> list2 = new MyLinkedList<Item>();

        Node point = first.next;
        while (point != null)
        {
            Node tmp = point;
            point = point.next;
            if(StdRandom.bernoulli(0.5))
                list1.enqueue(tmp);
            else list2.enqueue(tmp);
        }
        list1.shuffle();
        list2.shuffle();
        list1.last.next = list2.first.next;
        first = list1.first;
    }
    public static void main(String[] args)
    {
        int N = 30;
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        int[] a = new int[N];
        for(int i = 0; i < N; ++i)
            a[i] = i;
        for(int i = 0; i < N; ++i)
            list.enqueue(a[i]);
        list.shuffle();
        list.print();
        list.sort();
        list.print();
    }
}