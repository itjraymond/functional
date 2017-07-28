package ca.jent.gof.template;

/**
 *
 * @author jraymond
 */
public class ResourceUtilize extends AbstractResourceManipulatorTemplate {

    @Override
    protected void doSomethingWithResource() {
        r.utilizeResource();
    }
    
    public static void main(String[] args) {
        new ResourceUtilize().execute();
    }
    
}
