/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午10:44
 * To change this template use File | Settings | File Templates.
 */
public class longRandomPrime {
    public static long prime(int n)
    {
        while (true)
        {
            long a = StdRandom.uniform(1, 10);
            for(int i = 2; i <= n; ++i)
                a = a * 10 + StdRandom.uniform(10);
            if(isPrime(a))
                return a;
        }
    }

    private static boolean isPrime(long num)
    {
        for(int i = 2; i* i < num; ++i)
            if(num % i == 0)
                return false;
        return true;
    }
    public static void main(String[] args)
    {
        StdOut.println(prime(10));
    }
}
