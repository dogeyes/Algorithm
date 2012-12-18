/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-21
 * Time: 下午12:43
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_4 {
    public static void main(String[] args)
    {
        Stack<Character> stack = new Stack<Character>();
        char parentheses = StdIn.readChar();
        while(parentheses != '\n')
        {

            if(parentheses == '[' || parentheses == '(' || parentheses == '{')
                stack.push(parentheses);
            else
                if(!((parentheses == ']' && stack.pop() == '[') ||
                        (parentheses == '}' && parentheses == '{') ||
                        (parentheses == ')' && parentheses == '(')))
                {
                    StdOut.println(false);
                    return;
                }
            parentheses = StdIn.readChar();
        }
        StdOut.println(true);
    }
}
