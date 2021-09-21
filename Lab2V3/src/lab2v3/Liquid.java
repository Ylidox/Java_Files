package lab2v3;

public class Liquid extends Product{
    
    public Liquid(){
        super("liquid", 0);
    }
    public Liquid(Liquid l){
        super(l);
    }
    public Liquid(String name, double mass){
        super(name, mass);
    }
    
}
