package lab2v3;

public class Container extends Product{
    public Container(){
        super("container", "name", 0);
    }
    public Container(Container c){
        super(c);
    }
    public Container(String name, double mass){
        super("container", name, mass);
    }
}
