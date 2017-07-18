package ca.jent.functional.vehicle;

import java.awt.Color;

/**
 * The old ways of creating a VERY WRONG factory... because when we need to add 
 * a new Vehicle, we will need to remember to add code here...
 * @author jraymond
 */
public class VehicleFactoryLegacy {

    public static Vehicle create(String name) {
        switch (name) {
            case "car":
                return new Car(Color.RED);
            case "moto":
                return new Moto(Color.BLUE);
            default:
                throw new IllegalStateException("Invalid name for vehicle");
                    
        }
    }
}
