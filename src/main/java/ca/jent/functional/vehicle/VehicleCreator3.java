package ca.jent.functional.vehicle;

import java.awt.Color;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Here we are going to separate the creation of Vehicle from the Color assignment.
 * This mean I will be able to say things like: Create 5 Yellow Cars, 5 Green Cars,
 * and 5 Pink Moto.
 * In order to achieve this, we will create a Function<T,R> that returns another 
 * Function Supplier<R>
 * 
 * This technique is referred as:  Partial Application or Curried Function (any diff?)
 * 
 * @author jraymond
 */
public class VehicleCreator3 {
    
   public List<Vehicle> create5(Supplier<Vehicle> factory) {
       return IntStream.range(0, 5)
                       .mapToObj(i -> factory.get())
                       .collect(Collectors.toList());
   } 
   
   // The return function represent code and is not executed when partial is called.
   // Instead, the Color (T) is "captured" within the code ready to be apply.
   // If we look at the create5 method, we see that we get a function (the code) to
   // be executed.  When we call factory.get(), behind the seen, it will also
   // call function.apply(value) below which essentially *IS* the function Car::new
   // but we are passing one parameter to the constructor:  value (which is T or Color).
   // Hence we end up constructing a Car with a Color and yet we have de-coupled both
   // operation.
   public static <T,R> Supplier<R> partial(Function<T,R> function, T value) {
       return () -> function.apply(value);
   }
   
    public static void main(String[] args) {
        VehicleCreator3 creator = new VehicleCreator3();
        List<Vehicle> yellowCars = creator.create5(partial(Car::new, Color.YELLOW));
        List<Vehicle> pinkMoto   = creator.create5(partial(Moto::new, Color.PINK));
        
        pinkMoto.forEach(System.out::println);
    }
}
