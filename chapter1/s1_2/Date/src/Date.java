/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-20
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }
    public int getMonth()
    {
        return month;
    }
    public int getDay()
    {
        return day;
    }
    public int getYear()
    {
        return year;
    }
    public String toString()
    {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(other.getClass() != this.getClass())
            return false;
        Date that = (Date)other;
        return this.getDay() == that.getDay() && this.getMonth() == that.getMonth() & this.getYear() == that.getYear();
    }
}
