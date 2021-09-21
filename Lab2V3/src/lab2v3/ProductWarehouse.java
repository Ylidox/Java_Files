package lab2v3;
import java.util.ArrayList;

public class ProductWarehouse {
    private ArrayList<Product> products;
    
    public ProductWarehouse(){
        this.products = new ArrayList<>();
    }
    public ProductWarehouse(ArrayList<Product> c){
        this.products = new ArrayList<>(c);
    }
    
    public void addProduct(Product p){
        this.products.add(p);
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
    
    public void remove(String type){
        int index = 0;
        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            if(p.getType().equals(type)) index = i;
        }
        products.remove(index);
    }
    public void remove(int index){
        products.remove(index);
    }
}
