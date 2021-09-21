package lab2v3;

public abstract class Wagon {
    private Product product;
    
    public Wagon(){
        product = new Container();
    }
    public Wagon(Product product){
        this.product = product;
    }
    
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public void setProduct(String type, String name, double mass){
        this.product.setType(type);
        this.product.setName(name);
        this.product.setMass(mass);
    }
}
