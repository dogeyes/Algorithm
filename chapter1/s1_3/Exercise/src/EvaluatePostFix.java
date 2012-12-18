/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-22
 * Time: 下午7:13
 * To change this template use File | Settings | File Templates.
 */
public class EvaluatePostFix {
    public static double evaluatePostFix(String postFix)
    {
        String[] source = postFix.split(" ");
        Stack<Double> operand = new Stack<Double>();
        for(int i = 0; i < source.length; ++i)
        {
            if(source[i].equals("+"))
            {
                double a = operand.pop();
                double b = operand.pop();
                operand.push(a + b);
            }
            else if(source[i].equals("*"))
            {
                double a = operand.pop();
                double b = operand.pop();
                operand.push(a * b);
            }
            else if(source[i].equals("-"))
            {
                double a = operand.pop();
                double b = operand.pop();
                operand.push(a - b);
            }
            else if(source[i].equals("/"))
            {
                double a = operand.pop();
                double b = operand.pop();
                operand.push(a / b);
            }
            else
                operand.push(Double.parseDouble(source[i]));
        }
        return operand.pop();
    }
    public static void main(String[] args)
    {
        StdOut.println(evaluatePostFix(StdIn.readLine()));
    }
}
