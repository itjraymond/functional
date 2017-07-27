package ca.jent.oo;

/**
 *
 * @author jraymond
 */
public class Cert01 {

    public static void main(String[] args) {
        int x = 0;
        
        FLABEL: while(x<10){
            System.out.println("X: " + x);
            x++;
            if (x %2 == 0) {
                break FLABEL;
            }
            System.out.println("X2: " + x);
        }
    }
   
}
