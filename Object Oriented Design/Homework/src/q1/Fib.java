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
public class Fib {

    private final int f0, f1;

    /**
     * This Class represents a Fib function, this class encapsulate the values for Fib(0) and Fib(1)
     * @param f0 Value of Fib(0)
     * @param f1 Value of Fib(1)
     */
    public Fib(int f0, int f1) {
        this.f0 = f0;
        this.f1 = f1;
    }

    /**
     *Iterative solution, O(n).
     * @param n Index of Fibonacci number you want to calculate.
     * @return  Returns the nth Fibonacci number using iterative algorithms.
     */
    public int f(int n) {
        
        if (n < 0) throw new NumberFormatException("Value of n must be >= 0");   
        if (n == 0) return f0;
        if (n == 1) return f1; 
        
        int a = f0;
        int b = f1;
        int fib = 0;
        
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }

    /**
     * Recursive solution, O(2^n) which is very bad. Can be improved using memorization or other dynamic programming technique
     * @param n Index of Fibonacci number you want to calculate.
     * @return  Returns the nth Fibonacci number using iterative algorithms.
     */
    public int fRec(int n) {
        if (n < 0) throw new NumberFormatException("Value of n must be >= 0");
        if (n == 0) return f0; 
        if (n == 1) return f1; 
        return fRec(n - 1) + fRec(n - 2);
    }

}
