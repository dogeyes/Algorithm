import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
public class MultidimensionalSort {
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Vector[] vectors = new Vector[N];
        int M = StdIn.readInt();
        int[] a = new int[M];
        for(int i = 0; i < M; ++i)
            a[i] = i;
        for(int i = 0; i < N; ++i)
        {
            StdRandom.shuffle(a);
            vectors[i] = new Vector(M, a);
        }
        Arrays.sort(vectors);
        StdOut.println(Arrays.toString(vectors));
    }
}

class Vector implements Comparable<Vector>
{
    private int[] vector;
    private int size;
    public Vector(int M, int[] a)
    {
        vector = new int[M];
        for(int i = 0; i < M; ++i)
            vector[i] = a[i];
        size = M;
    }
    public int compareTo(Vector that)
    {
        for(int i = 0; i < size; ++i)
        {
            if(that.vector[i] != vector[i])
                return vector[i] - that.vector[i];
        }
        return 0;
    }
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < size; ++i)
            s.append(" " + vector[i]);
        s.append("\n");
        return s.toString();
    }
}
