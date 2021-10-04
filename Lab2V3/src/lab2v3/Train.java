package lab2v3;
import java.util.ArrayList;

public class Train {
    private Wagon[] wagons;
    
    public Train(){
        this.wagons = new Wagon[0];
    }
    public Train(Wagon[] c){
        this.wagons = c;
    }
    
    public void addWagon(Product p){
        int len = this.wagons.length; 
        this.increaseSize();
        this.wagons[len] = this.getWagonFromProduct(p);
//        System.out.println(this.wagons[len]);
    }
    
    public Wagon[] getWagons(){
        return wagons;
    }
    
    private void increaseSize(){
        Wagon[] newArr = new Wagon[this.wagons.length + 1];
        System.arraycopy(wagons, 0, newArr, 0, this.wagons.length);
        wagons = newArr;
    }
    
    private Wagon getWagonFromProduct(Product p){
        switch(p.getType()){
            case "container": 
                PlatformForContainers platform = new PlatformForContainers();
                platform.setContainer(p.getName(), p.getMass());
                return platform;
            case "liquid":
                Tank tank = new Tank();
                tank.setLiquid(p.getName(), p.getMass());
                return tank;
            case "car":
                PlatformForCars cars = new PlatformForCars();
                cars.setCar(p.getName(), p.getMass());
                return cars;
            case "bulk materials":
                TankForBulkMaterials bulk = new TankForBulkMaterials();
                bulk.setBulkMaterials(p.getName(), p.getMass());
                return bulk;
            default:
                return null;
        }
//        return null;
    }
    
//    public void remove(String type){
//        int index = 0;
//        for(int i = 0; i < wagons.size(); i++){
//            Wagon w = wagons.get(i);
//            if(w.getProduct().getName().equals(type)) index = i;
//        }
//        wagons.remove(index);
//    }
//    public void remove(int index){
//        wagons.remove(index);
//    }
}
