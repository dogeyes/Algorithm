/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 上午9:38
 * To change this template use File | Settings | File Templates.
 */
public class MyCPM {
    public static void main(String[] args)
    {
        In in = new In("jobsPC1.txt");
        int N = in.readInt(); in.readLine();
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(2 * N + 2);
        int s = 2*N, t = 2 * N + 1;
        for(int i = 0; i < N; ++i)
        {
            String[] a = in.readLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i, i + N,duration));
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i + N, t, 0.0));
            for(int j = 1; j < a.length; ++j)
            {
                G.addEdge(new DirectedEdge(i + N, Integer.parseInt(a[j]), 0));
            }
        }
        StdOut.println(G);
        MyAcyclicLP lp = new MyAcyclicLP(G, s);

        StdOut.println("Start times: ");
        for(int i = 0; i < N; ++i)
            StdOut.printf("%4d: %5.1f\n" , i , lp.distTo(i));
        StdOut.printf("%5.1f\n", lp.distTo(t));

        for(DirectedEdge e : lp.pathTo(t))
        {
            StdOut.print(e + " ");
        }
        StdOut.println();
    }
}
