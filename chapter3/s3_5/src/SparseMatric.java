import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-23
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
public class SparseMatric {
    private HashMap<Integer, SparseVector> rows;
    private HashMap<Integer, SparseVector> columns;
    public SparseMatric()
    {
        rows = new HashMap<Integer, SparseVector>();
        columns = new HashMap<Integer, SparseVector>();
    }

    public void put(int x, int y, double value)
    {
        if(value == 0)
            return;
        if(!rows.containsKey(x))
            rows.put(x, new SparseVector());
        rows.get(x).put(y, value);
        if(!columns.containsKey(y))
            columns.put(y, new SparseVector());
        columns.get(y).put(x, value);
    }
    public double get(int x, int y)
    {
        if(rows.containsKey(x))
            return rows.get(x).get(y);
        return 0;
    }
    public SparseMatric sum(SparseMatric that)
    {
        SparseMatric result = new SparseMatric();
        for(int i : this.rows.keySet())
        {
            SparseVector vector = this.rows.get(i).sum(that.rows.get(i));
            result.rows.put(i, vector);
        }
        for(int i : that.rows.keySet())
        {
            SparseVector vector = that.rows.get(i).sum(this.rows.get(i));
            result.rows.put(i, vector);
        }
        result.row2column();
        return result;
    }
    private void row2column()
    {
        for(int i : rows.keySet())
        {
            SparseVector vector = rows.get(i);
            for(int j : vector.keys())
            {
                if(!columns.containsKey(j))
                    columns.put(j, new SparseVector());
                columns.get(j).put(i, vector.get(j));
            }
        }
    }
    private void column2row()
    {
        for(int j : columns.keySet())
        {
            SparseVector vector = columns.get(j);
            for(int i : vector.keys())
            {
                if(!rows.containsKey(i))
                    rows.put(i, new SparseVector());
                rows.get(i).put(j, vector.get(i));
            }
        }
    }
    public SparseMatric multi(SparseMatric that)
    {
        SparseMatric result = new SparseMatric();
        for(int i : rows.keySet())
        {
            for(int j: that.columns.keySet())
                result.put(i, j, rows.get(i).dot(that.columns.get(j)));
        }
        return result;
    }
    public void print()
    {
        for(int i : rows.keySet())
        {
            StdOut.print(i + "[ ");
            rows.get(i).print();
        }
        StdOut.println();

        for(int j : columns.keySet())
        {
            StdOut.print(j + "[ ");
            columns.get(j).print();
        }
        StdOut.println();
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        SparseMatric matric1 = new SparseMatric();
        SparseMatric matric2 = new SparseMatric();
        for(int i = 0 ; i  < N; ++i)
        {
            int x = StdRandom.uniform(N);
            int y = StdRandom.uniform(N);
            matric1.put(x, y, StdRandom.uniform());
        }
        for(int i = 0 ; i  < N; ++i)
        {
            int x = StdRandom.uniform(N);
            int y = StdRandom.uniform(N);
            matric2.put(x, y, StdRandom.uniform());
        }

        matric1.print();
        matric2.print();
        //(matric1.sum(matric2)).print();
        (matric1.multi(matric2)).print();
    }
}
