package q5;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Jason Vega on 1/11/2017.
 */
public class PrimeFactorTest {

    public  static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number you want to factorize, number should be greater than 1.");
            int number = scanner.nextInt();
            PrimeFactorizer primeFactorizer = new PrimeFactorizer(number);
            System.out.print(primeFactorizer);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(iae.toString());
        }
    }
}
