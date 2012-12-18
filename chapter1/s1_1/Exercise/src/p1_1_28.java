import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-15
 * Time: 下午12:57
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_28 {
    public static void main(String[] args)
    {
        int[] number = In.readInts("in.txt");
        Arrays.sort(number);
        int p1, p2;
        p1 = 1;
        p2 = 1;
        for(; p2 < number.length; ++p2)
        {
            if(number[p2] != number[p2 - 1])
                number[p1++] = number[p2];
        }
        int[] resut = new int[p1];
        System.arraycopy(number, 0, resut, 0, p1);
        for(int i: resut)
            System.out.println(i);
    }
}
