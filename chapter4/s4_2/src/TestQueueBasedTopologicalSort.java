import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午7:06
 * To change this template use File | Settings | File Templates.
 */
public class TestQueueBasedTopologicalSort {
    public static void main(String[] args)
    {
        MyDigraph G = new MyDigraph(new In("tinyDG1.txt"));
        StdOut.println(G);

        QueueBasedTopologicalSort topological = new QueueBasedTopologicalSort(G);
        if(topological.hasTopologicalSort())
        {
            for(int w : topological.order())
            {
                StdOut.print(w + " ");
            }
            StdOut.println("----");
        }
        else
            StdOut.println("not DAG");
        int[] a = new int[G.V()];
        for(int i = 0; i < G.V(); ++i)
            a[i] = i;
        StdRandom.shuffle(a);
        Queue<Integer> queue = new Queue<Integer>();
        for(int i = 0; i < G.V(); ++i)
        {
            queue.enqueue(i);
        }
        StdOut.println(Arrays.toString(a));
        CheckTopological checkTopological = new CheckTopological(G, queue);
        StdOut.println(checkTopological.isTopologicalOrder());

    }
}
