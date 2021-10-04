package lab2v3;

public class Tank extends Wagon{
   
    public Tank(){
        super(new Liquid(), "tank");
    }
    public Tank(Liquid l){
        super(l, "tank");
    }
    
    public Product getLiquid(){
        return this.getProduct();
    }
    public void setLiquid(Liquid l){
        this.setProduct(l);
    }   
    public void setLiquid(String name, double mass){
        this.setProduct("liquid", name, mass);
    }
}
