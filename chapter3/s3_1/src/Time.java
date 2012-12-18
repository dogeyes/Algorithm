/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private int second;
    public Time (int h, int m, int s)
    {
        hour = h;
        minute = m;
        second = s;
    }
    public int compareTo(Time that)
    {
        if(hour != that.hour)
            return hour - that.hour;
        if(minute != that.minute)
            return minute - that.minute;
        return second - that.second;
    }
    public boolean equals(Object that)
    {
        if(this == that)
            return true;
        if(that == null)
            return false;
        if(!(that instanceof Time))
            return false;
        Time other = (Time)that;
        return hour == other.hour && minute == other.minute && second == other.second;
    }
}
