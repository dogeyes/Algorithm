import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt())
        {
            int n = in.nextInt();
            if(n >=2 && n <=5)
                System.out.println("The stranger will win!!");
            else if(n >= 44 && n <= 1900)
                System.out.println("I will win!!");
            else
                System.out.println("It's an endless game!!");
        }
    }
}
