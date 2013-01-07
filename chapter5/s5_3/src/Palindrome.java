import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dogeyes
 * Date: 13-1-7
 * Time: 下午9:44
 * To change this template use File | Settings | File Templates.
 */
public class Palindrome {
    public static void main(String[] args)
    {
        long hashLeft = 0;
        long hashRight = 0;
        int R = 256;
        long Q =  165317;
        int length = 0;
        long RL = 1;
        char[] input = new char[1000];
        while(true)
        {
            input[length++] = StdIn.readChar();
            StdIn.readChar();
            if(length % 2 == 0)
            {
                RL = (RL * R) %Q;
                hashRight = (hashRight + RL * input[length / 2 - 1]) % Q;
                hashLeft = ((hashLeft * R) % Q + input[length - 1] *R) % Q;
            }
            else
            {
                hashLeft = (hashLeft - (RL * input[length / 2]) % Q + Q) % Q;
                hashLeft = (hashLeft * R + input[length - 1] * R) % Q;
            }
            StdOut.println(hashRight  +" " +  hashLeft);

            /*long tmpleft = 0;
            long tmpRL = R;
            for(int i = 0; i < length / 2; ++i)
            {
                tmpleft = (tmpleft + input[i] * tmpRL) % Q;
                tmpRL = (tmpRL * R) % Q;
            }
            long tmpRight = 0;
            for(int i = (length + 1) / 2; i < length; ++i)
            {
                tmpRight = (tmpRight * R + input[i]) %Q;
            }
            tmpRight = (tmpRight * R) % Q;
            StdOut.println(tmpleft + " " + tmpRight);   */
            if(hashLeft == hashRight)
            {
                for(int k = 0; k < length; ++k)
                    StdOut.print(input[k] + " ");
                StdOut.println();
            }
        }
    }
}
