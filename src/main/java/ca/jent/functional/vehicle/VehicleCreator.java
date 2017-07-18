package ca.jent.functional.vehicle;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Typical implementation of a Factory Pattern.
 * @author jraymond
 */
interface VehicleFactory {
    public Vehicle create();
}

public class VehicleCreator {
    
    private final VehicleFactory redCarFactory   = () -> new Car(Color.RED);
    private final VehicleFactory blueMotoFactory = () -> new Moto(Color.BLUE);
    
    public List<Vehicle> create5(VehicleFactory factory) {
        return IntStream.range(0,5)
                        .mapToObj(i -> factory.create())
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        VehicleCreator creator = new VehicleCreator();
        
        List<Vehicle> redCars   = creator.create5(creator.redCarFactory);
        List<Vehicle> blueMotot = creator.create5(creator.blueMotoFactory);
        
        redCars.forEach(System.out::println);
        blueMotot.forEach(System.out::println);
        
    }
    
}
