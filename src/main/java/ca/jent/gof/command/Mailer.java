package ca.jent.gof.command;

/**
 *
 * @author jraymond
 */
public class Mailer implements Command {
    private final String message;
    
    public Mailer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Mailing: " + message);
    }
    
    
}
