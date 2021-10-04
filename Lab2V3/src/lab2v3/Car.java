package lab2v3;

public class Car extends Product{
    public Car(){
        super("car", "name", 0);
    }
    public Car(Car c){
        super(c);
    }
    public Car(String name, double mass){
        super("car", name, mass);
    }
}
