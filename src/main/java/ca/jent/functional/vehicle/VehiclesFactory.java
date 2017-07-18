package ca.jent.functional.vehicle;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Not bad.  However there are few problems with this implementation.
 * 1. We are doing two things:  register and create
 * 2. What if user calls "register" then "create" then "register" again?
 *    That will cause problems.  So we need to make sure that our caller
 *    cannot call register after calling create.
 * See the Builder versions.
 * @author jraymond
 */
public class VehiclesFactory {

    private final Map<String, Supplier<Vehicle>> map = new HashMap<>();
    
    public void register(String name, Supplier<Vehicle> supplier) {
        map.put(name,supplier);
    }
    
    public Vehicle create(String name) {
//        Supplier<Vehicle> supplier = map.get(name);
//        if (supplier == null) {
//            throw new IllegalArgumentException("Invalid name");
//        }
//        return supplier.get();
        // More compact, use getOrDefault (new in java 8)
        return map.getOrDefault(name, () -> { throw new IllegalArgumentException("Invalid name");})
                  .get();
    }
    
    public static void main(String[] args) {
        VehiclesFactory factory = new VehiclesFactory();
        factory.register("car", Car::new);
        factory.register("moto", Moto::new);
        
        // if for example we want to create a singleton for moto, we can do:
        Vehicle singleton = new Moto(Color.BLUE);
        factory.register("moto", () -> singleton);
        
    }
}
