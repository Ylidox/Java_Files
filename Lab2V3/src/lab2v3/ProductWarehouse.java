package lab2v3;

public class ProductWarehouse {
    private Product[] products;
    
    public ProductWarehouse(){
        this.products = new Product[0];
    }
    public ProductWarehouse(Product[] c){
        this.products = c;
    }
    
    public void addProduct(Product p){
        
        int len = this.products.length;
        this.increaseSize();
        this.products[len] = p;
    }

    public Product[] getProducts(){
        return products;
    }
    private void increaseSize(){
        Product[] newArr = new Product[this.products.length + 1];
        System.arraycopy(products, 0, newArr, 0, this.products.length);
        products = newArr;
    }
    public void pop(){
        Product[] newArr = new Product[this.products.length - 1];
        System.arraycopy(products, 0, newArr, 0, this.products.length - 1);
        products = newArr;
    }
}
