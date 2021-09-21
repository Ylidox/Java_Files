package lab2v3;

public class Tank extends Wagon{
    private Liquid liquid;
    
    public Tank(){
        super("liquid");
        liquid = new Liquid();
    }
    public Tank(Liquid l){
        super("liquid");
        liquid = l;
    }
    
    public Liquid getLiquid(){
        return liquid;
    }
    public void setLiquid(Liquid l){
        liquid = new Liquid(l);
    }   
    public void setLiquid(String type, double mass){
        liquid = new Liquid(type, mass);
    }
}
