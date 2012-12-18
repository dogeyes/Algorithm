import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-3
 * Time: 下午7:33
 * To change this template use File | Settings | File Templates.
 */
public class p2_2_21 {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        int[] list1 = new int[N];
        int[] list2 = new int[N];
        int[] list3 = new int[N];
        for(int i = 0; i < N; ++i)
        {
            list1[i] = StdRandom.uniform(0,  N);
            list2[i] = StdRandom.uniform(0, N);
            list3[i] = StdRandom.uniform(0,  N);
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        Arrays.sort(list3);
        StdOut.println(Arrays.toString(list1));
        StdOut.println(Arrays.toString(list2));
        StdOut.println(Arrays.toString(list3));
        int i = 0;
        int k = 0;
        int j = 0;
        while(true)
        {
            if(i >= list1.length || j >= list2.length || k >= list3.length)
                return;
            if(list1[i] == list2[j] && list1[i] == list3[k])
            {
                StdOut.println(list1[i]);
                return;
            }
            if(list1[i] <= list2[j] && list1[i] <= list3[k])
                i++;
            else if(list2[j] <= list1[i] && list2[j] <= list3[k])
                j++;
            else k++;
        }
    }
}
