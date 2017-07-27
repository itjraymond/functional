package ca.jent.functional;

/**
 * A collection of method that represent some kind of rules i.e. computation.
 * The principle is carefully name the abstraction of the rule such that the
 * user can refer to those abstractions instead of knowing the computation of
 * the rule.
 * Can we view these as "different behaviors?"
 * @author jraymond
 */
public class Rules {

    // You can view those method as a Type of:  double -> double
    public static double allowance(double d) { return d * 1.2; }
    
    public static double bonus(double d) { return d * 1.1; }
    
    public static double tax(double d) { return d * 0.7; }
    
    public static double surcharge(double d) { return d * 0.9; }
    
}
