package ca.jent.gof.observer;

/**
 *
 * @author jraymond
 */
public class Observer_B implements Listener {

    Observer_B(Observable observable) {
        
        observable.register(this, this);
    }
    
    @Override
    public void onEvent(Object event) {
        System.out.println("EVENT B: " + event);
    }

    
}
