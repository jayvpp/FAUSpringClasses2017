package q2;

import javax.sound.midi.SysexMessage;

/**
 * Created by Jason Vega on 1/10/2017.
 */
public class GreeterTester {

    public static void main(String[] args) {
        //Test case 1
        Greeter g1 = new Greeter("world");
        System.out.println("g1 = " + g1.sayHello());

        System.out.println();

        //Test case 2
        Greeter aux = new Greeter("parallel");
        g1.swapNames(aux);

        System.out.println("aux = " + aux.sayHello());
        System.out.println("g1 = " + g1.sayHello());

        System.out.println();

        //Test case 3
        Greeter g3 = new Greeter("world");
        Greeter g4 = g3.createQualifiedGreeter("beautifull");
        System.out.println("g3 = " + g3.sayHello());
        System.out.println("g4 = " + g4.sayHello());
    }
}
