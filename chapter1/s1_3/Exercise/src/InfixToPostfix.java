/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public class InfixToPostfix {
    public static void infixToPostfix(String infix)
    {

        Stack<String> operator = new Stack<String>();
        Stack<String> operand = new Stack<String>();
        String[] source = infix.split(" ");
        for(int i = 0; i < source.length; ++i)
        {
            if(source[i].equals("(") || source[i].equals("+") || source[i].equals("-") || source[i].equals("*") || source[i].equals("/"))
                operator.push(source[i]);
            else
                if(source[i].equals(")"))
                {
                    String now;
                    now = operator.pop();
                    while(!now.equals("("))
                    {
                        String a = operand.pop();
                        String b = operand.pop();
                        operand.push(a + b + now);
                        now = operator.pop();
                    }
                }
            else
                operand.push(source[i]);
        }
        StdOut.println(operand.pop());
    }
    public static void main(String[] args)
    {
        String in = StdIn.readLine();
        InfixToPostfix.infixToPostfix(in);
    }
}
