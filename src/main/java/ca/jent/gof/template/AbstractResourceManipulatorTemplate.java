package ca.jent.gof.template;

/**
 *
 * @author jraymond
 */
public abstract class AbstractResourceManipulatorTemplate {
    
    protected Resource r;
    
    private void openResource(){
        r = new Resource();
    }
    
    protected abstract void doSomethingWithResource();
    
    private void closeResource() {
        r.dispose();
        r = null;
    }
    
    // the template:
    public void execute() {
        openResource();
        try {
            doSomethingWithResource();
            
        } finally {
            closeResource();
        }
    }
}
