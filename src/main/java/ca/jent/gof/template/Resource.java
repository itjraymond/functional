package ca.jent.gof.template;

import java.util.Random;

/**
 *
 * @author jraymond
 */
public class Resource {

    public Resource(){
        System.out.println("Resource created...");
    }
    
    public void useResource() {
        doRiskyOperation();
        System.out.println("Resource used");
    }
    
    public void utilizeResource() {
        doRiskyOperation();
        System.out.println("Resource utilized");
    }
    
    public void dispose() {
        System.out.println("Resource disposed");
    }
    
    private void doRiskyOperation() {
        if (new Random().nextInt(4) == 0) {
            throw new RuntimeException();
        }
    }
    
    /**
     * Below it shows that we depend on the client (the caller) to call dispose().
     * A programmer may forget.  Let see if we can improve this using Template Pattern.
     * (see AbstractResourceManipulatorTemplate.java)
     * @param args 
     */
    public static void main(String[] args) {
        Resource r = new Resource();
        
        try {
            r.useResource();
            r.utilizeResource();
        } finally {
            r.dispose();
        }
    }
}
