package ca.jent.gof.observer;

/**
 * Using an anonymous class:  new Listener()...
 * @author jraymond
 */
public class Observer_A {
    
    Observer_A(Observable observable) {
        
        observable.register(this, new Listener() {
            @Override
            public void onEvent(Object event) {
                System.out.println("EVENT A: " + event);
            }
            
        } );
    }
}
