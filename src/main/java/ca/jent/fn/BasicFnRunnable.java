package ca.jent.fn;
/**
 * Purpose:  Practices the lambda 3 basic required concepts.
 * @author jraymond
 */
public class BasicFnRunnable {
    
    // 1.   Define a lambda Functional Interface (observe the Functional Type)
    //      Function Type:  () -> ()
    //      Functional Interface: Runnable
    static private final Runnable lambdaRunnable = () -> System.out.println("Takes no parameter(s) and return void");
    
    // 2.   Define a function that takes a Runnable as parameter
    //      Notice the call to "run"
    public void testRunnable(Runnable lambdaRunnable) {
        // Remember, the lambda hasn't been executed yet but it will here.
        lambdaRunnable.run();
    }
    
    // 3.   Usage
    //      The above (#1 and #2) are the "definitions" and do not get executed until it is 
    //      actually called.
    public static void main(String[] args) {
        BasicFnRunnable fn = new BasicFnRunnable();
        fn.testRunnable(lambdaRunnable);
    }
}
