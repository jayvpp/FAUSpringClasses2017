package q2;

/**
 * @author Jason Vega
 */

public class Greeter {

    private String name;

    /**
            Constructs a Greeter object that can greet a person or
            entity.
            @param aName the name of the person or entity who should
            be addressed in the greetings.*/

    public Greeter(String aName) {
        name = aName;
    }

    /**
     * Greet with a "Hello" message.
     *
     * @return a message containing "Hello" and the name of
     * the greeted person or entity.
     */

    public String sayHello() {
        return "Hello, " + name + "!";
    }

    /**
     * This method will swap the names of the current instance(this) and the Greether object passed in the parameter other
     * @param other represents other Greeter object we will use to swap the name
     */
    public void swapNames(Greeter other)
    {
        String aux = name;
        name = other.name;
        other.name = aux;
    }

    /***
     * Return new Greeter object with name = to the qualifier passed plus " " and the name of the current instance
     * @param qualifier string will be passes to create a new Greeter.
     * @return A new greeter with constains the qualifier passed as parameter
     */
    public Greeter createQualifiedGreeter(String qualifier)
    {
        return new Greeter(qualifier + " " + name);
    }
}

