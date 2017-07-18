package ca.jent.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Do some computation of a starting value (double) with the intent of
 * obtaining some result (double).  New Rule methods ("computation") type (double -> double) 
 * can be added at will and will not affect this class and yet provide the
 * correct computations. Open/Close Principle
 * @author jraymond
 */
public class RuleApplicator {
    
    private final List<Function<Double,Double>> fnAcc = new ArrayList<>();
    
    public RuleApplicator with(Function<Double, Double> fn) {
        fnAcc.add(fn);
        return this;
    }
    
    public double compute(double value) {
        return fnAcc.stream()
                    .reduce(Function.identity(), Function::andThen)
                    .apply(value);
    }
    
    /**
     * How to use this...  as we can see, we can create new Rules method in
     * the future without changing this class code (follow the 
     * Open/Close principle)
     */
    public static void main(String[] args) {
        double artifact = new RuleApplicator()
                             .with(Rules::allowance)
                             .with(Rules::bonus)
                             .with(Rules::surcharge)
                             .with(Rules::tax)
                             .compute(30000.00D); // 24948.0
        
        System.out.println("Artifact computation: " + artifact);
        
        // We can add a anonymous rule on the fly: (add 5% tax to a value for example)
        double result = new RuleApplicator()
                            .with(val -> val * 1.05)
                            .compute(30000.00D);
        
        System.out.println("5% tax on 30,000: " + result); // 31500
    }
}
