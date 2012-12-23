import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-12-22
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
public class SparseVector {
    private HashMap<Integer, Double> vector;
    public SparseVector(SparseVector that)
    {
        vector = new HashMap<Integer, Double>(that.vector);
    }
    public SparseVector()
    {
        vector = new HashMap<Integer, Double>();
    }
    public int size()
    {
        return vector.size();
    }
    public double get(int i)
    {
        Double d = vector.get(i);
        if(d == null)
            return 0;
        return d;
    }
    public void put(int i, double val)
    {
        vector.put(i, val);
    }
    public double dot(double[] that)
    {
        double sum = 0;
        for(int item : vector.keySet())
        {
            sum += get(item) * that[item];
        }
        return sum;
    }
    public double dot(SparseVector that)
    {
        double sum = 0;
        for(int item : vector.keySet())
        {
            sum += get(item) * that.get(item);
        }
        return sum;
    }
    public void print()
    {
        for(int i: vector.keySet())
        {
            StdOut.print(i + ":" +  vector.get(i) + " ");
        }
        StdOut.println();
    }
    public SparseVector sum(SparseVector that)
    {
        if(that == null)
            return new SparseVector(this);
        SparseVector result = new SparseVector();
        for(int i : vector.keySet())
        {
            double s = this.get(i) + that.get(i);
            if(s != 0)
                result.put(i, s);
        }
        for(int i : that.vector.keySet())
        {
            double s = this.get(i) + that.get(i);
            if(s != 0)
                result.put(i, s);
        }
        return result;
    }
    public Iterable<Integer>  keys()
    {
        return vector.keySet();
    }
    public static void main(String args[])
    {
        int N = StdIn.readInt();
        SparseVector[] vectors = new SparseVector[N];

        double[] x = new double[N];
        for(int i = 0; i < N; ++i)
        {
            x[i] = StdIn.readDouble();
            vectors[i] = new SparseVector();
        }
        for(int i =0; i < 2*N; ++i)
        {
            int u = StdRandom.uniform(0, N);
            int v = StdRandom.uniform(0, N);
            vectors[u].put(v, StdRandom.uniform());
        }

        for(int i = 0; i < N; ++i)
        {
            vectors[i].print();
        }

        StdOut.println();
        double[] b = new double[N];
        for(int i = 0; i < N; ++i)
        {
            b[i] = vectors[i].dot(x);
            StdOut.println(b[i]);
        }
        vectors[0].sum(vectors[1]).print();
    }
}
