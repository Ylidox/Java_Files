package lab2v3;

public class PlatformForCars extends Wagon{
    
    public PlatformForCars(){
        super(new Car());
    }
    public PlatformForCars(Car c){
        super(c);
    }
    
    public Product getCar(){
        return this.getProduct();
    }
    public void setCar(Car c){
        this.setProduct(c);
    }
    public void setCar(String name, double mass){
        this.setProduct("platformForCar", name, mass);
    }
}
