package lab2v3;
import java.util.ArrayList;
/**
 * Класс поезд. Описывает поведение состава.
 */
public class Train {
    private Wagon[] wagons;
    
    public Train(){
        this.wagons = new Wagon[0];
    }
    public Train(Wagon[] c){
        this.wagons = c;
    }
    /**
     * Метод добавления вагона по передаваемому продуктум
     * @param p 
     */
    public void addWagon(Product p){
        int len = this.wagons.length; 
        this.increaseSize();
        this.wagons[len] = this.getWagonFromProduct(p);
    }
    
    public Wagon[] getWagons(){
        return wagons;
    }
    /**
     * Метод увелечения размера массива вагонов на 1
     */
    private void increaseSize(){
        Wagon[] newArr = new Wagon[this.wagons.length + 1];
        System.arraycopy(wagons, 0, newArr, 0, this.wagons.length);
        wagons = newArr;
    }
    /**
     * Метод, принимающий тот или иной вид продукта, и возвращающий вагон 
     * соответствующего продукту типа
     * @param p
     * @return wagon
     */
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
    }
}
