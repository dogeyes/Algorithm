/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 下午12:38
 * To change this template use File | Settings | File Templates.
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap)
    {
        a =new String[cap];
    }
    public void push(String item)
    {
        a[N++] = item;
    }
    public String pop(String item)
    {
        return a[--N];
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public boolean isFull()
    {
        return N == a.length;
    }
    public int size()
    {
        return N;
    }
}
