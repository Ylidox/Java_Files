package lab2v3;

public class TankForBulkMaterials extends Wagon{
    private BulkMaterials bulkMaterials;
    
    public TankForBulkMaterials(){
        super("bulk materials");
        bulkMaterials = new BulkMaterials();
    }
    public TankForBulkMaterials(BulkMaterials b){
        super("liquid");
        bulkMaterials = b;
    }
    
    public BulkMaterials getLiquid(){
        return bulkMaterials;
    }
    public void setBulkMaterials(BulkMaterials b){
        bulkMaterials = new BulkMaterials(b);
    }   
    public void setBulkMaterials(String type, double mass){
        bulkMaterials = new BulkMaterials(type, mass);
    }
}
