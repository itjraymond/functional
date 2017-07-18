package ca.jent.functional.vehicle;

import java.awt.Color;

/**
 *
 * @author jraymond
 */
public interface Vehicle {
    
}

class Car implements Vehicle {
    private final Color color;
    
    public Car() {
        this.color = Color.BLACK;
    }
    
    public Car(Color color){
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "RED Car";
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
        return "BLUE Moto";
    }
}
