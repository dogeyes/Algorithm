import javax.print.attribute.standard.MediaSize;

public class p1_2_16 {
    public static void main(String[] args)
    {
        Rational rational = new Rational(1, 2);
        StdOut.println(rational);
        StdOut.println(rational.plus(new Rational(2, 3)));
        StdOut.println(rational.times(new Rational(4, 3)));
        StdOut.println(new Rational(Integer.MAX_VALUE + 10L, 1));
        StdOut.println(Integer.MAX_VALUE);
    }
}
class Rational
{
    private final long numerator;
    private final long denominator;
    public Rational(long numer, long denom)
    {
        assert numer < Integer.MAX_VALUE && numer > Integer.MIN_VALUE;
        assert denom < Integer.MAX_VALUE && denom > Integer.MIN_VALUE;
        long g = gcd(numer, denom);
        numerator = numer / g;
        denominator = denom / g;
    }
    private long gcd(long a, long b)
    {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    public Rational plus(Rational b)
    {
        long numer = numerator * b.denominator + denominator * b.numerator;
        long denom = denominator * b.denominator;
        long g = gcd(numer, denom);
        return new Rational(numer / g, denom / g);
    }
    public Rational minus(Rational b)
    {
        long numer = numerator * b.denominator - denominator * b.numerator;
        long denom = denominator * b.denominator;
        long g = gcd(numer, denom);
        return new Rational(numer / g, denom / g);
    }
    public Rational times(Rational b)
    {
        long numer = numerator * b.numerator;
        long denom = denominator * b.denominator;
        long g = gcd(numer, denom);
        return new Rational(numer / g, denom / g);
    }
    public Rational divides(Rational b)
    {
        long numer = numerator * b.denominator;
        long denom = denominator * b.numerator;
        long g = gcd(numer, denom);
        return new Rational(numer / g, denom / g);
    }
    public boolean equals(Object that)
    {
        if(this == that)
            return true;
        if(that == null)
            return false;
        if(that.getClass() != this.getClass())
            return  false;
        Rational other = (Rational)that;
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }
    public String toString()
    {
        return numerator + "/" + denominator;
    }

}
