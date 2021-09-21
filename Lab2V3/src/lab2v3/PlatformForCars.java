package lab2v3;
import java.util.ArrayList;

public class PlatformForCars extends Wagon{
    private ArrayList<Car> cars;
    
    public PlatformForCars(){
        super("cars");
        this.cars = new ArrayList<>();
    }
    public PlatformForCars(ArrayList<Car> c){
        super("containers");
        this.cars = new ArrayList<>(c);
    }
    
    public ArrayList<Car> getCar(){
        return cars;
    }
    public void setCar(ArrayList<Car> c){
        this.cars = new ArrayList<>(c);
    }   
}
