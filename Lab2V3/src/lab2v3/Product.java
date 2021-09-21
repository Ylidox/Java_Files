package lab2v3;

public abstract class Product {
    private String type;
    private String name;
    private double mass;
    
    public Product(){
        type = "product";
        name = "";
        mass = 0;
    }
    public Product(Product l){
        type = l.type;
        mass = l.mass;
        name = l.name;
    }
    public Product(String name, double mass){
        type = "product";
        this.type = name;
        this.mass = mass;
    }
    
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public double getMass(){
        return mass;
    }
    public void setMass(double m){
        mass = m;
    }
    public void setType(String t){
        type = t;
    }
    public void setName(String n){
        name = n;
    }
}
