package ca.jent.gof.strategy;

/**
 *
 * @author jraymond
 */
public class Application {

    public static void main(String[] args) {
        TextEditor t1 = new TextEditor(new PlainTextFormatter());
        TextEditor t2 = new TextEditor(new ErrorTextFormatter());
        TextEditor t3 = new TextEditor(new ShortTextFormatter());
        
        t1.publish("t1: Some plain text that is long");
        t1.publish("ERROR t1: some plain text");
        t1.publish("t1: short");

        t2.publish("t2: Some plain text that is long");
        t2.publish("ERROR t2: some plain text");
        t2.publish("t2: short");

        t3.publish("t3: Some plain text that is long");
        t3.publish("ERROR t3: some plain text");
        t3.publish("t3: short");

    }
}
