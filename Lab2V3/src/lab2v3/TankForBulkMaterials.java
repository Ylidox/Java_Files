package lab2v3;

public class TankForBulkMaterials extends Wagon{
    private BulkMaterials bulkMaterials;
    
    public TankForBulkMaterials(){
        super(new BulkMaterials(), "tankForBulkMaterials");
    }
    public TankForBulkMaterials(BulkMaterials b){
        super(b, "tankForBulkMaterials");
    }
    
    public Product getBulkMaterials(){
        return this.getProduct();
    }
    public void setBulkMaterials(BulkMaterials b){
        this.setProduct(b);
    }   
    public void setBulkMaterials(String name, double mass){
        this.setProduct("bulkMaterials", name, mass);
    }
}
