/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 12-11-15
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class p1_1_33 {
    public static void main(String[] args)throws MatrixSizeNotMatch
    {
        double[] x = {1,2,3,4,5};
        double[] y = {1,2,3,4,5};
        double[] z = {1,2,3,4};
        StdOut.println(Matrix.dot(x, y));

        double[][] a = {
                {1,1,1,1},
                {2,2,2,2},
                {3,3,3,3},
                {4,4,4,4},
                {5,5,5,5}
        };
        double[][] c = Matrix.transpose(a);
        for(int i = 0 ; i < c.length; ++i)
        {
            for(int j = 0; j < c[0].length; ++j)
                StdOut.print(c[i][j] +" ");
            StdOut.println();
        }
        double[] d = Matrix.mult(a, z);
        for(int i = 0; i < d.length; ++i)
            StdOut.print(d[i] + " ");
        StdOut.println();

        double[] e = Matrix.mult(z, Matrix.transpose(a));
        for(int i = 0 ; i < e.length; ++i)
            StdOut.print(e[i] + " ");
        StdOut.println();

        double[][] f = Matrix.mult(a, Matrix.transpose(a));
        for(int i = 0 ; i < c.length; ++i)
        {
            for(int j = 0; j < c[0].length; ++j)
                StdOut.print(f[i][j] +" ");
            StdOut.println();
        }

    }
}

class MatrixSizeNotMatch extends Exception
{
}

class Matrix
{
    static double dot(double[] x, double[] y)throws MatrixSizeNotMatch
    {
        if(x.length != y.length)
            throw new MatrixSizeNotMatch();

        double sum  = 0;
        for(int i = 0 ; i < x.length; ++i)
        {
            sum += x[i] * y[i];
        }
        return sum;
    }
    static double[][] mult(double[][] a, double[][] b)throws MatrixSizeNotMatch
    {
        if(a[0].length != b.length)
            throw new MatrixSizeNotMatch();
        double[][] c = new double[a.length][b[0].length];
        for(int i = 0 ; i < a.length; ++i)
        {
            for(int j = 0; j < b[0].length; ++j)
            {
                for(int k = 0; k < b.length; ++k)
                    c[i][j] += a[i][k] * b[k][j];
            }
        }
        return c;

    }

    static double [][] transpose(double[][] a)
    {
        double[][] b = new double[a[0].length][a.length];
        for(int i = 0 ; i < a.length; ++i)
            for(int j = 0; j < a[0].length; ++j)
                b[j][i] = a[i][j];
        return b;
    }

    static double[]  mult(double[][] a, double[] x)throws MatrixSizeNotMatch
    {
        if(a[0].length != x.length)
            throw new MatrixSizeNotMatch();

        double[] b = new double[a.length];
        for(int i = 0; i < a.length; ++i)
        {
            for(int j = 0; j < a[0].length; ++j)
                b[i] += a[i][j] * x[j];
        }
        return b;
    }

    static double [] mult(double [] y, double[][] a)throws MatrixSizeNotMatch
    {
        if(y.length != a.length)
            throw new MatrixSizeNotMatch();

        double[] c = new double[a[0].length];
        for(int i = 0; i  < a[0].length; ++i)
        {
            for(int j = 0; j < a.length; ++j)
            {
                c[i] += y[j] * a[j][i];
            }
        }

        return c;
    }

}

