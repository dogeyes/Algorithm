import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 13-1-9
 * Time: 下午8:47
 * To change this template use File | Settings | File Templates.
 */
public class MyNFA18 {
    private char[] re;
    private Digraph G;
    private int M;

    public MyNFA18(String regexp)
    {
        Stack<Integer> ops = new Stack<Integer>();
        re = preprocess(regexp);

        M = re.length;
        G = new Digraph(M + 1);

        //StdOut.println(Arrays.toString(re));

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

    private char[] preprocess(String regexp)
    {
        int N = regexp.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < N; ++i)
        {
            if(regexp.charAt(i) == '+')
            {
                Stack<Character> copy1 = new Stack<Character>();
                Stack<Character> copy2 = new Stack<Character>();
                int parNum = 0;
                char now = stack.pop();
                copy1.push(now);
                copy2.push(now);
                if(now == ')') parNum++;
                while (parNum != 0)
                {
                    now = stack.pop();
                    copy1.push(now);
                    copy2.push(now);
                    if(now == ')') parNum++;
                    else if(now == '(') parNum--;
                }
                while (!copy1.isEmpty())
                    stack.push(copy1.pop());
                while (!copy2.isEmpty())
                    stack.push(copy2.pop());
                stack.push('*');
            }
            else
                stack.push(regexp.charAt(i));
        }

        char[] result = new char[stack.size()];
        for(int i = stack.size() - 1; i >= 0; --i)
        {
            result[i] = stack.pop();
        }
        return result;
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
