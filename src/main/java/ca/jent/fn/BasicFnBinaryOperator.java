package ca.jent.fn;

import java.util.function.BinaryOperator;

/**
 *
 * @author jraymond
 */
public class BasicFnBinaryOperator {

    // 1.   Define a lambda Functional Interface implementation (observe the Functional Type)
    //      Function Type: (T,T) -> T
    //      Functional Interface: BinaryOperator<T>
    static private final BinaryOperator<Integer> lambdaBiOperator = (a,b) -> a + b;
    
    // 2.   Define a function that takes the BinaryOperator<T> implementation as 
    //      parameter.  Notice the call to "apply"
    public Integer testBinaryOperator(Integer a, Integer b, BinaryOperator<Integer> sum) {
        return sum.apply(a, b);
    }
    
    // 3.   Usage
    //      The above (#1 and #2) are the "definitions" and do not get executed until it is
    //      actually called.
    public static void main(String[] args) {
        BasicFnBinaryOperator fn = new BasicFnBinaryOperator();
        Integer sum = fn.testBinaryOperator(5, 6, lambdaBiOperator);
        System.out.println("SUM: " + sum);
    }
}
