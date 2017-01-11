package q5;

import java.util.ArrayList;

/**
 * Created by jason on 1/11/2017.
 */
public class PrimeFactorizer {

    private final int n;
    private String factorizationRepresentation;
    boolean computedBefore = false;
    private ArrayList<Integer> primes, exponents;

    /**
     * Constuctor for PrimeFactorizaer
     * Initialize the object with value n
     * @param n N has to be greater than 1, otherwise we will throw IllegalArgumentException
     */
    public PrimeFactorizer(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("N has to be greater than 1");
        } else
        {
            this.n = n;
            primes = new ArrayList<>();
            exponents = new ArrayList<>();
        }
    }

    /**
     * Getter, return the target number we want to factorize
     * @return
     */
    public int getN() {
        return n;
    }

    /***
     * Compute Factorization. We do not re-compute if it was calculated before
     */
    public void compute() {
        if(computedBefore) return;

        if(n == 1) {System.out.println("No possible decomposition, 1 is neither a prime number nor a composite number."); return;}

        int factorCandidate = 1;
        int currentFactor = n;

        do{
            currentFactor = computePrimeFactor(currentFactor, factorCandidate);
            factorCandidate++;
        }while(currentFactor != 1);

        computedBefore = true;
        generateFactorizationString();
    }

    //This Api function is weard
    /*public void getFactorAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents)
    {
        PrimeFactorizer factorizer = new PrimeFactorizer(n);
        factorizer.compute();
        primes =  factorizer.primes;
        exponents = factorizer.exponents;
    }*/

    /***
     *This function is for internal use of the clase, no entry point for public access.
     * @param n number you want to compute the maximun prime factor using prime k.
     * @param k number used as a base
     * @return
     */
    private int computePrimeFactor(int n, int k) {
        if (k == 1) return n;
        int count = 0;
        while (n % k == 0) {
            count++;
            n /= k;
        }
        if (count == 0) return n;
        primes.add(k);
        exponents.add(count);
        return n;
    }

    /***
     * Generate the nice factorization string base on the prime factorization generated using method
     * compute.
     */
    private void generateFactorizationString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n + " = ");

       for(int i= 0; i < primes.size(); i++)
       {
           int fact = primes.get(i);
           int exponent = exponents.get(i);
           if(exponent == 1 )
               stringBuilder.append(fact);
           else
               stringBuilder.append(fact + "^" + exponent);
           if(i < primes.size()-1) stringBuilder.append("*");
       }

       stringBuilder.append("\n");
       factorizationRepresentation = stringBuilder.toString();
    }

    /***
     * @return The string representing the factorization of the N.
     * If we previusly calculate the value, do not re-compute, we are caching the
     * value
     */
    public String toString()
    {
        if(!computedBefore)
            compute();
        return factorizationRepresentation;
    }


}
