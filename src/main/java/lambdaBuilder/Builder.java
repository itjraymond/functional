package lambdaBuilder;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * This is "close to perfect" implementation of a builder.  No Builder class or object 
 * are created but instead an implementation of Builder interface is passed as
 * parameter to factory.
 * In addition, note that we are adding a Functional Interface to our map (i.e. code)
 * which is returned when calling "create(name)" which is also executed at the time
 * of that call.  Pretty neat.
 * @author jraymond
 */
public interface Builder {
    public void register(String name, Supplier<Vehicle> supplier);
}

interface VehicleFactory {
    Vehicle create(String name);
    
    static VehicleFactory factory(Consumer<Builder> consumer) {
        Map<String,Supplier<Vehicle>> map = new HashMap<>();
        consumer.accept(map::put);
        return name -> map.getOrDefault(name, () -> { throw new IllegalArgumentException("Invalid vehicle name");})
                          .get();
    }
}
//   USAGE (need to put this into another class ?
//   VehicleFactory factory = VehicleFactory.factory(builder -> {
//       builder.register("car", Car::new);
//       builder.register("moto", Moto::new);
//   });
//   create any vehicle from the factory...
//   Vehicle car = factory.create("car");

// Infrastructure

interface Vehicle {}

class Car implements Vehicle {
    private Color color;
    
    public Car(){
        this.color = Color.BLACK;
    }
    public Car(Color color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car " + color.toString();
    }
    
}
class Moto implements Vehicle {
    private Color color;
    
    public Moto(){
        this.color = Color.BLACK;
    }
    public Moto(Color color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Moto " + color.toString();
    }
    
}
