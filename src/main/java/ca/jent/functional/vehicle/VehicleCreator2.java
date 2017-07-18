package ca.jent.functional.vehicle;

import java.awt.Color;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class will use a predefine Functional Interface in place of the
 * VehicleFactory interface which is also a Functional Interface.
 * In fact, VehicleFactory Functional Type can be view as:
 * 
 *     () -> Vehicle
 * 
 * We can find in java.util.function.* package a functional interface with the
 * same signature:
 * 
 *     Supplier<Vehicle> :  () -> Vehicle
 * 
 * But we should separate the creation of Vehicle and And setting the Color.
 * @author jraymond
 */
public class VehicleCreator2 {
    
    private final Supplier<Vehicle> redCarFactory   = () -> new Car(Color.RED);
    private final Supplier<Vehicle> blueMotoFactory = () -> new Moto(Color.BLUE);

    public List<Vehicle> create5(Supplier<Vehicle> factory) {
        return IntStream.range(0,5)
                        .mapToObj(i -> factory.get())
                        .collect(Collectors.toList());
    }
    
    
    public static void main(String[] args) {
        VehicleCreator2 creator = new VehicleCreator2();
        
        List<Vehicle> redCars   = creator.create5(creator.redCarFactory);
        List<Vehicle> blueMotot = creator.create5(creator.blueMotoFactory);
        
        redCars.forEach(System.out::println);
        blueMotot.forEach(System.out::println);
        
    }
}
