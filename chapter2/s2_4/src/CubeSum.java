/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-10
 * Time: 下午7:10
 * To change this template use File | Settings | File Templates.
 */
public class CubeSum {
    private static class Cube implements Comparable<Cube>
    {
        int i;
        int j;
        int cube;
        public Cube(int i, int j)
        {
            this.i = i;
            this.j = j;
            cube = i * i * i + j * j * j;
        }
        public int compareTo(Cube other)
        {
            return cube - other.cube;
        }
        public String toString()
        {
            return cube + " " + i + " " + j;
        }
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        MinPQ<Cube> pq = new MinPQ<Cube>(N + 1);

        for(int i = 0; i <= N; ++i)
        {
            pq.insert(new Cube(i, 0));
        }
        while(!pq.isEmpty())
        {
            Cube min = pq.delMin();
            StdOut.println(min);
            if(min.j >= N)
                continue;
            pq.insert(new Cube(min.i, min.j + 1));
        }
    }
}
