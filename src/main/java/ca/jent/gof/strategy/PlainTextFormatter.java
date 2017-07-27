package ca.jent.gof.strategy;

/**
 * Formatter that do nothing to its input (no filter and no formatting).
 * 
 * A problem with this:  Both "functionality": filter and format, are tied
 * together in an implementation.  This mean that if we do use a PlainTextFormatter,
 * you will get the filter and format as implemented here.  If you needed
 * a plain filter with something more special for format, you would need to create
 * yet another TextFormatter.
 * Lambda will allow us to separate the two with no effort and much less code.
 * @author jraymond
 */
public class PlainTextFormatter implements TextFormatter {

    @Override
    public boolean filter(String text) {
        return true;
    }

    @Override
    public String format(String text) {
        return text;
    }
    
}
