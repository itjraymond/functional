package ca.jent.gof.command;

/**
 *
 * @author jraymond
 */
public class FileSaver implements Command {
    
    private final String message;
    
    public FileSaver(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Saving: " + message);
    }
    
    
}
