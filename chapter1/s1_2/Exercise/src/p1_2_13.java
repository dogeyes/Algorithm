/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 上午10:35
 * To change this template use File | Settings | File Templates.
 */
public class p1_2_13 {
    public static void main(String[] args)
    {
        Transaction tran = new Transaction("dd", new Date(12, 9, 2012), 100);
        StdOut.println(tran);
    }
}

class Transaction implements Comparable<Transaction>
{
    private String who;
    private Date when;
    private int amount;
    public Transaction(String who, Date when, int amount)
    {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }
    public String who()
    {
        return who;
    }
    public Date when()
    {
        return when;
    }
    public int amount()
    {
        return amount;
    }
    public int compareTo(Transaction that)
    {
        return this.amount() - that.amount();
    }
    public String toString()
    {
        return who + " " + when + " " + amount;
    }
    public boolean equals(Object that)
    {
        if(this == that) return true;
        if(that == null) return false;
        if(that.getClass() != this.getClass())
            return false;
        Transaction other = (Transaction) that;
        return this.amount() == other.amount() && this.when().equals(other.when()) && this.who().equals(other.who());
    }

}