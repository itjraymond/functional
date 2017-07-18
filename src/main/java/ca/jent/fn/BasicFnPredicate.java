package ca.jent.fn;

import java.util.function.Predicate;

/**
 *
 * @author jraymond
 */
public class BasicFnPredicate {

    // 1.   Define a lambda Functional Interface (observe the Functional Type)
    //      Function Type: T -> Boolean
    //      Functional Interface: Predicate<T>
    static private final Predicate<String> lambdaPredicate = message -> message.startsWith("Hello");

    // 2.   Define a function that takes the Predicate<String> as parameter.
    //      Notice the call to "test"
    public boolean testPredicate(String message, Predicate<String> lambdaPredicate) {
        return lambdaPredicate.test(message);
    }
    
    // 3.   Usage
    //      The above (#1 and #2) are the "definitions" and do not get executed until it is
    //      actually called.
    public static void main(String[] args) {
        BasicFnPredicate fn = new BasicFnPredicate();
        if (fn.testPredicate("Hello World", lambdaPredicate)) {
            System.out.println("Yep, message started with Hello");
        } else {
            System.out.println("You need to debug");
        }
        
        
    }
}
