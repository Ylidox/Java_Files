package lab2v3;
/**
 * Абстрактный класс, описывающий поведение вагонов
 */

public abstract class Wagon {
    private Product product;
    private String type;
    
    public Wagon(){
        product = new Container();
        type = "container";
    }
    public Wagon(Product product, String type){
        this.product = product;
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public Product getProduct(){
        return product;
    }
    public void setType(String type){
        this.type = type;
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
