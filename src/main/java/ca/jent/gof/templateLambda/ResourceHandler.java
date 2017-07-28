package ca.jent.gof.templateLambda;

import java.util.Random;
import java.util.function.Consumer;

/**
 * Using lambda, we need one (or two if pull Resource out) class(es) instead of 4
 * or more (because we will always need more class each time we need to implement
 * the abstract class to provide different implementation).  Lambda as a clear
 * benefit of decoupling functionality and removing boiler plate (or noise) code.
 * "Better signal/noise ratio"
 * @author jraymond
 */
public class ResourceHandler {

    public static void withResource(Consumer<Resource> consumer) {
        Resource r = new Resource();
        try {
            consumer.accept(r);
        } finally {
            r.dispose();
        }
    }
    
    /**
     * Usage
     */
    public static void main(String[] args) {
        withResource(resource -> resource.useResource());
        withResource(resource -> resource.utilizeResource());
    }
}

class Resource {
    
    public void useResource() {
        doRiskyOperation();
        System.out.println("Resource used");
    }
    
    public void utilizeResource() {
        doRiskyOperation();
        System.out.println("Resource utilized");
    }
    
    public void dispose(){
        System.out.println("Resource disposed");
    }
    
    private void doRiskyOperation() {
        if (new Random().nextInt(4) == 0) {
            throw new RuntimeException();
        }
    }
}
