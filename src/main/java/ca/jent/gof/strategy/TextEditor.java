package ca.jent.gof.strategy;

/**
 *
 * @author jraymond
 */
public class TextEditor {
    // composition
    private final TextFormatter textFormatter;
    
    public TextEditor(TextFormatter textFormatter){
        this.textFormatter = textFormatter;
    }
    
    public void publish(String text) {
        if (textFormatter.filter(text)){
            System.out.println("Publishing: " + textFormatter.format(text));
        }
    }
}

// How it is filtered and formated are the "strategies".
// We can have several strategies for "HOW TO DO TEXT FILTERING and FORMATTING"
// So each implementation of TextFormatter represent one strategy.
interface TextFormatter {
    boolean filter(String text);
    String format(String text);
}