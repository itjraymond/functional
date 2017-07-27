package ca.jent.gof.commandLambda;

import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author jraymond
 */
public class Commands {

    public static void log(String message) {
        System.out.println("Logging: " + message);
    }
    
    public static void save(String message) {
        System.out.println("Saving: " + message);
    }
    
    public static void mail(String message) {
        System.out.println("Mailing: " + message);
    }
        
    public static Runnable partial(Consumer<String> consumer, String value) {
        return () -> consumer.accept(value);
    }
    
    /**
     * Executor of Commands
     */
    public static void execute(List<Runnable> tasks) {
        tasks.forEach(Runnable::run);
    }
}
