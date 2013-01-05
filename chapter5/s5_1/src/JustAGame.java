import java.util.Arrays;
import java.util.HashMap;
public class JustAGame {
    public static void main(String[] args)
    {
        int t = StdIn.readInt();
        int n = StdIn.readInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; ++i)
        {
            int key = StdIn.readInt();
            if(map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        int N = map.size();
        int[] keys = new int[N];
        int[] values = new int[N];
        int i = 0;
        for(int k : map.keySet())
        {
            keys[i] = k;
            values[i] = map.get(k);
            i++;
        }
        StdOut.println(Arrays.toString(keys));
        StdOut.println(Arrays.toString(values));
        StdOut.println(count(keys,values, t, 0));
    }
    private static int count(int[] keys, int[] values, int sum, int ind)
    {
        if(sum == 0)
            return 1;
        if(sum < 0 || ind >= keys.length)
            return 0;
        int result = 0;
        result += count(keys, values, sum, ind + 1);
        if(values[ind] > 0)
        {
            sum -= keys[ind];
            values[ind]--;
            result += count(keys, values, sum, ind);
            sum += keys[ind];
            values[ind]++;
        }

        return result;
    }
}
