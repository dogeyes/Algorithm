
public class p1_1_3 {
    public static void main(String[] args)
    {
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if(a == b && b == c)
            StdOut.println("Equal");
        else
            StdOut.println("Not equal");
    }
}
