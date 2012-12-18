/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 上午10:14
 * To change this template use File | Settings | File Templates.
 */
public class p1_2_11 {
    public static void main(String[] args)
    {
        int month = StdIn.readInt();
        int day = StdIn.readInt();
        int year = StdIn.readInt();
        SmartDate date = new SmartDate(month, day, year);
        StdOut.println(date);
        StdOut.println(new SmartDate("10/9/2012"));

    }
}
class SmartDate
{
    private final int month;
    private final int day;
    private final int year;
    public SmartDate(String s)
    {
        String[] ints = s.split("/");
        month = Integer.parseInt(ints[0]);
        day = Integer.parseInt(ints[1]);
        year = Integer.parseInt(ints[2]);
    }
    public SmartDate(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
        if(!check(m, d, y))
            throw new RuntimeException("Date error");
    }
    private boolean check(int m, int d, int y)
    {
        if(y % 400 != 0 && y % 4 == 0 && m == 2 && d == 29)
            return true;
        if(m > 12)
            return false;
        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
            if(d > 31)
                return false;
        if(m == 2)
            if(d > 28)
                return false;
        if(d > 30)
            return false;
        return true;
    }
    public int month()
    {
        return month;
    }
    public int day()
    {
        return day;
    }
    public int year()
    {
        return year;
    }
    public String toString()
    {
        return month() + "/" + day() + "/" + year();
    }

}
