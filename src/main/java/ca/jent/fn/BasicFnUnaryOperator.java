package ca.jent.fn;

import java.util.function.UnaryOperator;

/**
 *
 * @author jraymond
 */
public class BasicFnUnaryOperator {

    // 1.   Define a lambda Functional Interface implementation (observe the Functional Type)
    //      Function Type: T -> T
    //      Functional Interface: UnaryOperator<T>
    static private final UnaryOperator<Integer> lambdaUnaryOperator = a -> 2 * a;
    
    // 2.   Define a function that takes the UnaryOperator<T> implementation as
    //      parameter.  Notice the call to "apply"
    public Integer testUnaryOperator(Integer a, UnaryOperator<Integer> lambdaUnaryOperator){
        return lambdaUnaryOperator.apply(a);
    }
    
    // 3.   Usage
    //      The above (#1 and #2) are the "definitions" and do not get executed until it is
    //      actually called.
    public static void main(String[] args) {
        BasicFnUnaryOperator fn = new BasicFnUnaryOperator();
        Integer n = fn.testUnaryOperator(50, lambdaUnaryOperator);
        System.out.println("Value: " + n);
    }
}
