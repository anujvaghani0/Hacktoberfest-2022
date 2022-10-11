import java.util.Scanner;
public class Prime {

     public static void main(String[] args)
     {
         Test prime = new Test();
         prime.read();
         prime.check();
     }
}
class Test
{
    Scanner sc = new Scanner(System.in);
    int num, count = 0;

    void read()
    {
        System.out.println("Enter a number: ");
        num = sc.nextInt();
    }

    void check()
    {
        if(num<=0)
        {
            System.out.println("Enter positive number");
        }
        else if (num==1)
        {
            System.out.println("Neither prime nor composite");
        }
        else
        {
            for(int i = 1; i<=num; i++)
            {
                if (num % i == 0)
                    count++;
            }
                if(count==2)
                    System.out.println("Prime number");
                else
                    System.out.println("Not a Prime number");

        }

    }
}
