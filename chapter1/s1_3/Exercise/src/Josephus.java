/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-24
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
public class Josephus {
    private class Node
    {
        int item;
        Node next;
        Node previouse;
    }
    private Node point;
    public Josephus(int M, int N)
    {
        point = new Node();
        point.item = 0;
        point.next = point;
        point.previouse = point;
        int count = 1;
        while(count < M)
        {
            Node tmp = new Node();
            tmp.item = count;
            tmp.previouse = point.previouse;
            tmp.next = point;
            point.previouse.next = tmp;
            point.previouse = tmp;
            count++;
        }
        for(int i = 0; i < M ; ++i)
        {
            count = 1;
            while (count < N)
            {
                point = point.next;
                count++;
            }
            point.next.previouse = point.previouse;
            point.previouse.next = point.next;
            StdOut.print(point.item + " ");
            point = point.next;
        }
    }
    public static void main(String[] args)
    {
        Josephus josephus = new Josephus(7, 2);

    }
}
