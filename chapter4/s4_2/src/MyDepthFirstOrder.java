import javax.swing.text.StyledEditorKit;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-26
 * Time: 下午9:54
 * To change this template use File | Settings | File Templates.
 */
public class MyDepthFirstOrder {
    private boolean[] marked;
    private MyDigraph G;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    public MyDepthFirstOrder(MyDigraph G)
    {
        this.G = G;
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); ++i)
        {
            if(!marked[i])
                dfs(i);
        }
    }
    private void dfs(int v)
    {
        marked[v] = true;
        pre.enqueue(v);
        for(int w: G.adj(v))
            if(!marked[w])
            {
                dfs(w);
            }
        post.enqueue(v);
        reversePost.push(v);
    }
    public Iterable<Integer> pre()
    {
        return pre;
    }
    public Iterable<Integer> post()
    {
        return post;
    }
    public Iterable<Integer> reversePost()
    {
        return reversePost;
    }

}
