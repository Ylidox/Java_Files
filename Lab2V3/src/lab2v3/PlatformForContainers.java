package lab2v3;

public class PlatformForContainers extends Wagon{
    
    public PlatformForContainers(){
        super(new Container());
    }
    public PlatformForContainers(Container c){
        super(c);
    }
    
    public Product getContainer(){
        return this.getProduct();
    }
    public void setContainer(Container c){
        this.setProduct(c);
    }   
    public void setContainer(String name, double mass){
        this.setProduct("platformForContainer", name, mass);
    }
}
