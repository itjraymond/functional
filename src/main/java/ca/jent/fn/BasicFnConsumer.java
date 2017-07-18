package ca.jent.fn;

import java.util.function.Consumer;

/**
 * Purpose: Practices the lambda 3 basic required concepts.
 * @author jraymond
 */
public class BasicFnConsumer {
    
    // 1.   Define a lambda Functional Interface (observe the Functional Type)
    //      Function Type: T -> ()
    //      Functional Interface: Consumer<T>
    static private final Consumer<String> lambdaConsumer = message -> System.out.println("Takes one parameter and return void.  The parameter consumed is: " + message);
    
    // 2.   Define a function that takes a Consumer<String> as parameter.
    //      Notice the call to "accept"
    public void testConsumer(Consumer<String> lambdaConsumer) {
        String message = "My value to be consumed";
        lambdaConsumer.accept(message);
    }
    
    public void testConsumerFor(Consumer<String> lambdaConsumer, String message) {
        lambdaConsumer.accept(message);
    }
    
    // 3.   Usage
    //      The above (#1 and #2) are the "definitions" and do not get executed
    //      until it is actually called.
    public static void main(String[] args) {
        BasicFnConsumer consumer = new BasicFnConsumer();
        consumer.testConsumer(lambdaConsumer);
        consumer.testConsumerFor(lambdaConsumer, "Hello World");
    }
}
