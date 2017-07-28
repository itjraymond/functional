package ca.jent.gof.strategyLambda;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Using lambda we de-couple the "filter" and "format" functionalities.  In addition, any new filter
 * and/or format, we do not need to create new classes that implements those functionalities.
 * We can say that each strategy type (filter, format, etc...) has been separated by parameterizing
 * them with functions.
 * @author jraymond
 */
public class Application {

    public static void publish(String text, Predicate<String> filter, UnaryOperator<String> format) {
        if (filter.test(text)) {
            System.out.println(format.apply(text));
        }
    }
    public static void main(String[] args) {
        
        publish("Some very long plain text", s -> true, s -> s);
        publish("Some very long plain text", TextStrategies::filterPlain, TextStrategies::formatPlain);
        publish("ERROR TEST", TextStrategies::filterError, TextStrategies::formatShort);
        publish("ERROR TEST", TextStrategies::filterError, TextStrategies::formatError);
        publish("ERROR TEST", TextStrategies::filterError, TextStrategies::formatPlain);
        
        publish("Some text", TextStrategies::filterShort, TextStrategies::formatError);
        publish("Some text that is long and should not be printed", TextStrategies::filterShort, TextStrategies::formatError);

    }
}
