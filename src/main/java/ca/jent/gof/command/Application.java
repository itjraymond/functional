package ca.jent.gof.command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jraymond
 */
public class Application {
    
    public static void main(String[] args) {
        List<Command> tasks = new ArrayList<>();
        tasks.add(new Logger("hello logger"));
        tasks.add(new FileSaver("hello file saver"));
        tasks.add(new Mailer("hello mailer"));
        
        new Executor().execute(tasks);
    }
}
