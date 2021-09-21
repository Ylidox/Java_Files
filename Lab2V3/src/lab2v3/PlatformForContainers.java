package lab2v3;

public class PlatformForContainers extends Wagon{
    private Container container;
    
    public PlatformForContainers(){
        super("containers");
        this.container = new Container();
    }
    public PlatformForContainers(Container c){
        super("containers");
        this.container = c;
    }
    
    public Container getContainer(){
        return container;
    }
    public void setContainer(Container c){
        container = new Container(c);
    }   
    public void setContainer(String type, double mass){
        container = new Container(type, mass);
    }
}
