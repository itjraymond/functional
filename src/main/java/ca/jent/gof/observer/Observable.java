package ca.jent.gof.observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The "Observable" is an Object that provide certain functionality to be
 * executed.  In the process of computing that functionality, there may
 * be other objects (Observer) that would have an interest about that 
 * computation.  Below is the boiler plate code that is needed to 
 * register those Observers such that when something of interest happen,
 * we can send them the event.
 * @author jraymond
 */
public class Observable {
    
    private final Map<Object, Listener> listeners = new ConcurrentHashMap<>();
    
    public void register(Object key, Listener listener) {
        listeners.put(key, listener);
    }
    
    public void unregister(Object key) {
        listeners.remove(key);
    }
    
    public void sendEvent(Object event) {
        for (Listener listener : listeners.values()) {
            listener.onEvent(event);
        }
    }
    
    /**
     * USAGE:
     */
    public static void main(String[] args) {
        Observable observable = new Observable();
        
        new Observer_A(observable);
        new Observer_B(observable);
        observable.sendEvent("Oh my!  A computation of interest just happened");
    }
}
