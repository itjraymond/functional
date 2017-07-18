package ca.jent.builder;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Not bad but...
 * We have a "reusable" builder that we may not want the user to "re-use" since
 * its usage is really use once i.e. do the build of the factory;  and then done.
 * How can we do that?
 * @author jraymond
 */
public class Builder {
    private final Map<String,Supplier<Vehicle>> map = new HashMap<>();
    
    public void register(String name, Supplier<Vehicle> supplier) {
        map.put(name, supplier);
    }
    
    public VehicleFactory create() {
        return name -> map.getOrDefault(name, () -> { throw new IllegalArgumentException();})
                          .get();
                  
    }
    
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.register("car", Car::new);
        builder.register("moto", Moto::new);
        VehicleFactory factory = builder.create();
        Vehicle car = factory.create("car");
        System.out.println("Car: " + car);
        // the problem is that I have the Builder object which I can reuse but
        // the intent is not to be reusable because what we are after is
        // one factory which has been configured by the builder.
    }
}

/* I N F R A S T R U C T U R E */
// String -> Vehicle  :: Function<String,Vehicle>
interface VehicleFactory {
    Vehicle create(String name);
}

interface Vehicle {}

class Car implements Vehicle {
    private final Color color;
    public Car(){
        this.color = Color.BLACK;
    }
    public Car(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car:" + color.toString();
    }
    
    
}
class Moto implements Vehicle {
    private final Color color;
    public Moto(){
        this.color = Color.BLACK;
    }
    public Moto(Color color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Moto:" + color.toString();
    }
}
