/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Jason Vega
 */
public class FibTester {

    public static void main(String[] args) {
        int f0, f1, n = 0;
        Fib fib = null;

        if (args.length != 3) {
            System.out.println("Incorrect number of parameters: You must pass exactly 3 parameters(f0 f1 N).");
            System.exit(0);
        }
        try {
            f0 = Integer.parseInt(args[0]);
            f1 = Integer.parseInt(args[1]);
            n = Integer.parseInt(args[2]);

            if (n < 0) {
                System.err.println("Value of N has to be greater or equal that 0");
                System.exit(0);
            }

            fib = new Fib(f0, f1);
        } catch (NumberFormatException e) {
            System.err.println("Incorrect parameter formatting, all 3 paramters have to integer.");
            System.exit(0);
        }

        //Call iterative Fib function
        System.out.println("Iterative version");
        for (int i = 0; i <= n; i++) {
            System.out.print(fib.f(i) + " ");
        }

        System.out.println();

        //Call recursice Fib function
        System.out.println("Recursive version");
        for (int i = 0; i <= n; i++) {
            System.out.print(fib.fRec(i) + " ");
        }
    }

}
