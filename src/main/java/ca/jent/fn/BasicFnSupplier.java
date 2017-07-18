package ca.jent.fn;

import java.util.function.Supplier;

/**
 * Purpose: Practices the lambda 3 basic required concepts.
 * @author jraymond
 */
public class BasicFnSupplier {
    
    // 1.   Define a lambda Functional Interface (observe the Functional Type)
    //      Function Type:  () -> T
    //      Functional Interface: Supplier<T>
    static private final Supplier<String> lambdaSupplier = () -> "Supplied String";
    
    // 2.   Define a function that takes a Supplier<String> as parameter.
    //      Notice the call to "get"
    public String testSupplier(Supplier<String> supplier){
        return supplier.get();
    }
    // 3.   Usage
    //      The above (#1 and #2) are the "definitions" and do not get executed
    //      until it is actually called.
    public static void main(String[] args) {
        BasicFnSupplier supplier = new BasicFnSupplier();
        String string   = supplier.testSupplier(lambdaSupplier);
        String whatever = supplier.testSupplier(()-> "Hello World");
        
        System.out.println("Supplier: " + string);
        System.out.println("Supplier: " + whatever);
    }
}

/**
 * NOTE:    We say that the lambda implements the Functional Interface.
 *          This mean that step #2, uses the method defined by the
 *          Functional Interface to "execute" the implementation.
 *          The implementation should always be read as:
 *      1.  What goes in (the parameters if any)
 *      2.  What goes out (void or T)
 */
