/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 13-1-5
 * Time: 下午11:17
 * To change this template use File | Settings | File Templates.
 */
public class MyStringSET {
    private MyEmptyTST<Object> tst;
    private static Object mark = new Object();

    public MyStringSET()
    {
        tst = new MyEmptyTST<Object>();
    }

    public void add(String key)
    {
        tst.put(key, mark);
    }

    public boolean contains(String key)
    {
        if(tst.get(key) == null)
            return false;
        else
            return true;
    }

    public void delete(String key)
    {
        tst.delete(key);
    }

    public boolean isEmpty()
    {
        return tst.isEmpty();
    }

    public int size()
    {
        return tst.size();
    }

    public Iterable<String> keys()
    {
        return tst.keys();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(String s: keys())
        {
            sb.append(s + " ");
        }
        return sb.toString();
    }
}
