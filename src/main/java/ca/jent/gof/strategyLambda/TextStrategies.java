package ca.jent.gof.strategyLambda;

/**
 *
 * @author jraymond
 */
public class TextStrategies {

    // Filter strategies
    public static boolean filterPlain(String text) {
        return true;
    }
    public static boolean filterError(String text) {
        return text.startsWith("ERROR");
    }
    public static boolean filterShort(String text) {
        return text.length() < 20;
    }
    
    // Format strategies
    public static String formatPlain(String text) {
        return text;
    }
    public static String formatError(String text) {
        return text.toUpperCase();
    }
    public static String formatShort(String text) {
        return "SHORT: " + text.toLowerCase();
    }
    
}
