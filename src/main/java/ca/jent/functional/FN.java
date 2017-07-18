package ca.jent.functional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * Adaptation of the OO Strategy pattern in Functional Programming style.  Note that we
 * have minimum infrastructure and more flexibilities.
 * @author jraymond
 */
public class FN {
    public static void main(String[] args) {
        Converter converter = new Converter();
        // how to use the converter without currying (need to pass both, conversion rate and value all the time).
        double tenMilesInKm = converter.apply(1.609D, 10.0D);  // pass in the conversion rate and the value to be converted
        double t20MilesInKm = converter.apply(1.609D, 20.0D);  // again pass the same conversion rate...  repeating yourself :-) -> use curried fn
        
        // So instead use curried fn with your favorite conversion rate
        Function<Double, Double> miles2km = converter.curried1(1.609D);
        Function<Double, Double> ounce2Gr = converter.curried1(28.345D);
        // now that you have "assigned" the conversion rate, you don't need to repeat yourself :-p
        double fiveMilesInKm = miles2km.apply(5.0D);
        double sixMilesInKm  = miles2km.apply(6.0D);
        double fiveOunceInGr = ounce2Gr.apply(5.0D);
        double sixOunceInGr  = ounce2Gr.apply(6.0D);
        
        // You can also do the opposit: assigne your value, say 10, then ask what is 10
        // submitted to different conversion rate
        Function<Double, Double> ten = converter.curried2(10.0D); // can use either curried1 or 2
        // Now you apply different conversions
        double tenAsKm = ten.apply(1.609D);
        double tenAsGr = ten.apply(28.345D);
        
        // You can also apply a conversion rate to agregates
        List<Double> values = Stream.of(10.0D,20.0D,50.0D)
                                    .map(miles2km::apply)
                                    .collect(toList());
        
        values.stream().forEach(System.out::println);
        
        // or can print directly, using whatever converter
        Stream.<Double>of(10.0D,20.0D,50.0D)
              .map(ounce2Gr::apply)
              .forEach(System.out::println);
    }
}

// INFRASTRUCTURE NEEDED:
class Converter implements ExtendedBiFunction<Double, Double, Double> {
    @Override
    public Double apply(Double conversionRate, Double value) {
        return conversionRate * value;
    }
}

// we do this because we want some curried functions
@FunctionalInterface
interface ExtendedBiFunction<T,U,R> extends BiFunction<T,U,R> {
    
    default Function<U,R> curried1(T t) {
        return u -> apply(t,u);
    }
    
    default Function<T,R> curried2(U u) {
        return t -> apply(t,u);
    }
}


























