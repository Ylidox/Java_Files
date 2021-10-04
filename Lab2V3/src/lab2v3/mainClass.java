package lab2v3;

public class mainClass {


    public static void main(String[] args) {
        WarehouseManager manager = new WarehouseManager();
        manager.loadingProductsToWarehouse();
        manager.loadingProductsFromWarehouseToTrain();

        manager.hello();
        manager.showTrain();
        manager.showWarehouse();

    }
    
}
