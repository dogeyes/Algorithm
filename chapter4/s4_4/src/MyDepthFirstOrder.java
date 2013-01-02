/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 13-1-2
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class MyDepthFirstOrder {
    private EdgeWeightedDigraph G;
    private Stack<Integer> reversePost;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private boolean[] marked;
    public MyDepthFirstOrder(EdgeWeightedDigraph G)
    {
        this.G = G;
        reversePost = new Stack<Integer>();
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        marked = new boolean[G.V()];
        for(int i =0 ;i < G.V(); ++i)
        {
            if(!marked[i])
                dfs(i);
        }
    }
    private void dfs(int v)
    {
        marked[v] = true;
        pre.enqueue(v);
        for(DirectedEdge e: G.adj(v))
        {
            int w = e.to();
            if(!marked[w])
                dfs(w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }
    public Iterable<Integer> reversePost()
    {
        return reversePost;
    }
    public Iterable<Integer> pre()
    {
        return pre;
    }
    public Iterable<Integer> post()
    {
        return post;
    }
}
