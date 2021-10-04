package lab2v3;

public class Liquid extends Product{
    
    public Liquid(){
        super("liquid", "name", 0);
    }
    public Liquid(Liquid l){
        super(l);
    }
    public Liquid(String name, double mass){
        super("liquid", name, mass);
    }
    
}
