package ca.jent.gof.observerLambda;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 *
 * @author jraymond
 */
public class Observable {
    
    private final Map<Object, Consumer<Object>> listeners = new ConcurrentHashMap<>();
    
    public void register(Object key, Consumer<Object> listener) {
        listeners.put(key, listener);
    }
    
    public void unregister(Object key) {
        listeners.remove(key);
    }
    
    public void sendEvent(Object event) {
        listeners.values().forEach(listener -> listener.accept(event));
    }
    
    
    /**
     * Usage:
     */
    public static void main(String[] args) {
        Observable observable = new Observable();
        observable.register("key1", e -> System.out.println("A: " + e));
        observable.register("key2", e -> System.out.println("B: " + e));
        observable.sendEvent("Much simpler and easier to understand");
    }
}
