package ca.jent.gof.commandLambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jraymond
 */
public class Application {
    
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> Commands.log("hello logger"));
        tasks.add(() -> Commands.save("hello saver"));
        tasks.add(() -> Commands.mail("hello mailer"));
        Commands.execute(tasks);
        
        /**
         * Using function composition: separate the "action" and "message"
         */
        List<Runnable> taskList = new ArrayList<>();
        taskList.add(Commands.partial(Commands::log,  "Hello LAMBDA logger"));
        taskList.add(Commands.partial(Commands::mail, "Mailer LAMBDA Yah!"));
        taskList.add(Commands.partial(Commands::save, "Yo Save with LAMBDA"));
        taskList.add(Commands.partial(Commands::mail, "LAMBDA Mailer Youpi!"));
        taskList.add(Commands.partial(Commands::save, "LAMBDA Save ...right on"));
        taskList.add(Commands.partial(Commands::log,  "LAMBDA Logger go go go"));
        
        
        Commands.execute(taskList);
    }
}
