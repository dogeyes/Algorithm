/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 下午1:36
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_9 {
    public static void main(String[] args)
    {
        Stack<String> operator = new Stack<String>();
        Stack<String> result = new Stack<String>();
        String[] source = StdIn.readLine().split(" ");
        for(int i = source.length - 1; i >= 0; --i)
        {
            if(source[i].equals(")"))
            {
                operator.push(")");
                result.push(")");
            }else if(source[i].equals("*") || source[i].equals("/") || source[i].equals("-") || source[i].equals("+"))
            {
                while(operator.peek() != ")")
                {
                    result.push("(");
                    operator.pop();
                    operator.pop();
                }
                operator.push(source[i]);
                result.push(source[i]);
            }
            else
                result.push(source[i]);
            operator.print();
        }
        while (!operator.isEmpty())
        {
            result.push("(");
            while(operator.pop() != ")");
        }
        result.print();
    }
}
