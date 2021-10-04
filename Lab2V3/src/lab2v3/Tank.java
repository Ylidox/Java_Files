package lab2v3;

public class Tank extends Wagon{
   
    public Tank(){
        super(new Liquid());
    }
    public Tank(Liquid l){
        super(l);
    }
    
    public Product getLiquid(){
        return this.getProduct();
    }
    public void setLiquid(Liquid l){
        this.setProduct(l);
    }   
    public void setLiquid(String name, double mass){
        this.setProduct("tank", name, mass);
    }
}
