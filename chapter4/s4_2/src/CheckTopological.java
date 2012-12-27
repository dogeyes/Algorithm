/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 上午9:18
 * To change this template use File | Settings | File Templates.
 */
public class CheckTopological {
    private boolean[] marked;
    private boolean isTopologicalOrder;
    public CheckTopological(MyDigraph G, Iterable<Integer> permutation)
    {
        marked = new boolean[G.V()];
        isTopologicalOrder = true;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i: permutation)
            stack.push(i);

        while (!stack.isEmpty())
        {
            int s = stack.pop();
            dfs(G, s);
            if(!isTopologicalOrder)
                break;
        }
    }
    private void dfs(MyDigraph G, int s)
    {
        marked[s] = true;
        for(int w: G.adj(s))
        {
            if(!isTopologicalOrder)
                return;
            if(!marked[w])
            {
                isTopologicalOrder = false;
                return;
            }
        }
    }
    public boolean isTopologicalOrder()
    {
        return isTopologicalOrder;
    }
}
