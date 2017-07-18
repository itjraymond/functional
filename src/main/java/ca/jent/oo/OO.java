package ca.jent.oo;

import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import java.util.List;

/**
 * Small example of OO Strategy pattern.
 * Notice all the infrastructure needed in Java.  
 * @author jraymond
 */
public class OO {
    
    static List<Double> convertValues(List<Double> values, Converter converter) {
        return values.stream().map(value -> converter.convert(value)).collect(toList());
    }
    
    public static void main(String[] args) {
        List<Double> list = Stream.of(10.0D,20.0D,50.0D).collect(toList());
        
        convertValues(list, new Mi2KmConverter()).forEach(System.out::println);
        convertValues(list, new Ou2GrConverter()).forEach(System.out::println);
    }
    
    
}

// INFRASTRUCTURE NEEDED:
interface Converter {
    double convert(double value);
}

abstract class AbstractConverter implements Converter {
    @Override
    public double convert (double value) {
        return value * getConversionRate();
    }

    public abstract double getConversionRate();
}

class Mi2KmConverter extends AbstractConverter {

    @Override
    public double getConversionRate() {
        return 1.609;
    }
}

class Ou2GrConverter extends AbstractConverter {

    @Override
    public double getConversionRate() {
        return 28.345;
    }
}
    

















