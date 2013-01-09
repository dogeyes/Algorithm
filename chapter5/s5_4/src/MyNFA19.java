import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: daixing
 * Date: 13-1-9
 * Time: 下午8:47
 * To change this template use File | Settings | File Templates.
 */
public class MyNFA19 {
    private class Node
    {
        int type;  //1 a char; 2 a set of char; 3 the range;
        SET<Character> set;
        char low;
        char high;
        boolean in;
        public Node(char low, char high, boolean in)
        {
            this.low = low;
            this.high = high;
            this.in = in;
            type = 3;
        }
        public Node(SET<Character> set, boolean in)
        {
            this.in = in;
            this.set = set;
            type = 2;
        }
        public Node(char c)
        {
            low = c;
            type = 1;
        }
        public boolean match(char c)
        {
            if(c == '(' || c == ')' || c == '*' || c == '+' || c == '|')
                return low == c;
            if(type == 1)
            {
                if(low == c || low == '.')
                    return true;
                return false;
            }
            if(type == 2)
            {
                if(in && set.contains(c))
                    return true;
                else if(!in && !set.contains(c))
                    return true;
                return false;
            }
            if(type == 3)
            {
                if(in && c>=low && c <= high)
                    return true;
                else if(!in && (c<low || c > high))
                    return true;
                return false;
            }
            return false;
        }
        public String toString()
        {
            switch (type)
            {
                case 1: return low + "";
                case 2: StringBuilder sb = new StringBuilder();
                        for(char c: set) sb.append(c); return sb.toString() + " " + in;
                case 3: return low + " " + high + " " + in;
            }
            return "";
        }
    }
    private Node[] re;
    private Digraph G;
    private int M;

    public MyNFA19(String regexp)
    {
        Stack<Integer> ops = new Stack<Integer>();
        re = preprocess(regexp);

        M = re.length;
        G = new Digraph(M + 1);

        StdOut.println(Arrays.toString(re));

        for(int i = 0; i < M; ++i)
        {
            int lp = i;
            if(re[i].match('(') || re[i].match('|'))
                ops.push(i);
            else if(re[i].match(')'))
            {
                int or = ops.pop();
                if(re[or].match('|'))
                {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                }
                else lp = or;

            }
            if(i < M - 1 && re[i + 1].match('*'))
            {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if(re[i].match('*') || re[i].match('(') || re[i].match(')'))
                G.addEdge(i, i + 1);
        }
    }

    private Node[] preprocess(String regexp)
    {
        int N = regexp.length();
        Stack<Node> stack = new Stack<Node>();
        for(int i = 0 ; i < N; ++i)
        {
            if(regexp.charAt(i) == '+')
            {
                Stack<Node> copy1 = new Stack<Node>();
                Stack<Node> copy2 = new Stack<Node>();
                int parNum = 0;
                Node now = stack.pop();
                copy1.push(now);
                copy2.push(now);
                if(now.match(')')) parNum++;
                while (parNum != 0)
                {
                    now = stack.pop();
                    copy1.push(now);
                    copy2.push(now);
                    if(now.match(')')) parNum++;
                    else if(now.match('(')) parNum--;
                }
                while (!copy1.isEmpty())
                    stack.push(copy1.pop());
                while (!copy2.isEmpty())
                    stack.push(copy2.pop());
                stack.push(new Node('*'));
            }
            else if(regexp.charAt(i) == '[')
            {
                i++;
                boolean in;
                if(regexp.charAt(i) == '^')
                {
                    in = false;
                    i++;
                }
                else
                    in = true;
                SET<Character> set = new SET<Character>();
                for(; regexp.charAt(i) != ']'; ++i)
                {
                    if(regexp.charAt(i + 1) == '-')
                    {
                        for(char c = regexp.charAt(i); c <= regexp.charAt(i + 2); ++c)
                            set.add(c);
                        i = i + 2;
                    }
                    else
                        set.add(regexp.charAt(i));
                }
                stack.push(new Node(set, in));
            }
            else
                stack.push(new Node(regexp.charAt(i)));
        }

        Node[] result = new Node[stack.size()];
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
                    if(re[j].match(txt.charAt(i)))
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
