package ca.jent.gof.template;

/**
 *
 * @author jraymond
 */
public class ResourceUse extends AbstractResourceManipulatorTemplate {

    @Override
    protected void doSomethingWithResource() {
        r.useResource();
    }
    
    public static void main(String[] args) {
        new ResourceUse().execute();
    }
}
