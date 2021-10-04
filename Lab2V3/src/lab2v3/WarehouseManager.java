package lab2v3;

public class WarehouseManager {
    private Train train;
    private ProductWarehouse warehouse;
    private TableManager tm;
    public WarehouseManager(){
        train = new Train();
        warehouse = new ProductWarehouse();
        tm = new TableManager();
    }
    
    private void loadingProductToWarehouse(Product p){
        warehouse.addProduct(p);
    }
    
    public void loadingProductsToWarehouse(){
        loadingProductToWarehouse(new Liquid("нефть", 73300));
        loadingProductToWarehouse(new Liquid("дизельное топливо", 73300));
        loadingProductToWarehouse(new Liquid("мазут", 73300));
        loadingProductToWarehouse(new BulkMaterials("зерно", 76000));
        loadingProductToWarehouse(new BulkMaterials("уголь", 76000));
        loadingProductToWarehouse(new BulkMaterials("песок", 76000));
        loadingProductToWarehouse(new Container("CP-2001", 5000));
        loadingProductToWarehouse(new Container("QW-1207", 3000));
        loadingProductToWarehouse(new Car("Ford", 2300));
        loadingProductToWarehouse(new Car("Nissan", 1500));
    }
    
    public void loadingWagon(Product p){
        train.addWagon(p);
    }
    
    public void loadingProductsFromWarehouseToTrain(){
        Product[] products = warehouse.getProducts();
        for(int i = products.length - 1; i >= 0; i--){
            this.loadingWagon(products[i]);
            warehouse.pop();
        }
    }
    
    public void showWarehouse(){
        tm.showWarehouse(warehouse);
    }
    
    public void showTrain(){
        tm.showTrain(train);
    }
    
    public void hello(){
        tm.hello();
    }
}
