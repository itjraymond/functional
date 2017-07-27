package ca.jent.gof.command;

import java.util.List;

/**
 *
 * @author jraymond
 */
public class Executor {

    public void execute(List<Command> tasks) {
        for (Command command : tasks) {
            command.run();
        }
    }
}
