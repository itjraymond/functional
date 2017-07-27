package ca.jent.gof.command;

/**
 *
 * @author jraymond
 */
public class Logger implements Command {

    private final String message;
    
    public Logger(String message) {
        this.message = message;
    }
    
    @Override
    public void run() {
        System.out.println("Logging: " + message);
    }
    
}

interface Command {
    public void run();
}
