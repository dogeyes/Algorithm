/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 13-1-9
 * Time: 下午8:47
 * To change this template use File | Settings | File Templates.
 */
public class MyNFA {
    private char[] re;
    private Digraph G;
    private int M;

    public MyNFA(String regexp)
    {
        Stack<Integer> ops = new Stack<Integer>();
        M = regexp.length();
        G = new Digraph(M + 1);
        re = regexp.toCharArray();

        for(int i = 0; i < M; ++i)
        {
            int lp = i;
            if(re[i] == '(' || re[i] == '|')
                ops.push(i);
            else if(re[i] == ')')
            {
                int or = ops.pop();
                if(re[or] == '|')
                {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                }
                else lp = or;

            }
            if(i < M - 1 && re[i + 1] == '*')
            {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if(re[i] == '*' || re[i] == '(' || re[i] == ')')
                G.addEdge(i, i + 1);
        }
    }


    public boolean recognizes(String txt)
    {
        int N = txt.length();
        Bag<Integer> pc = new Bag<Integer>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for(int i = 0; i < G.V(); ++i)
            if(dfs.marked(i))
                pc.add(i);

        for(int i = 0; i < N; ++i)
        {
            Bag<Integer> match = new Bag<Integer>();
            for(int j : pc)
                if(j < M)
                    if(re[j] == txt.charAt(i) || re[j] == '.')
                        match.add(j + 1);
            pc = new Bag<Integer>();
            dfs = new DirectedDFS(G, match);

            for(int j = 0; j < G.V(); ++j)
                if(dfs.marked(j))
                    pc.add(j);

        }

        for(int i: pc)
            if(i == M)
                return true;
        return false;

    }
}
